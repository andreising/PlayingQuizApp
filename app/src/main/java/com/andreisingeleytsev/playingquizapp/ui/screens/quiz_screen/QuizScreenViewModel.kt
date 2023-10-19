package com.andreisingeleytsev.playingquizapp.ui.screens.quiz_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andreisingeleytsev.playingquizapp.common.Constants
import com.andreisingeleytsev.playingquizapp.data.game.model.AnswerResult
import com.andreisingeleytsev.playingquizapp.data.game.model.QuestionItem
import com.andreisingeleytsev.playingquizapp.data.game.model.QuizItem
import com.andreisingeleytsev.playingquizapp.domain.game.usecases.GetQuizListUseCase
import com.andreisingeleytsev.playingquizapp.domain.game.usecases.GetResultUseCase
import com.andreisingeleytsev.playingquizapp.domain.game.usecases.GetTimeFlowUseCase
import com.andreisingeleytsev.playingquizapp.domain.game.usecases.SendResultUseCase
import com.andreisingeleytsev.playingquizapp.ui.utils.Routes
import com.andreisingeleytsev.playingquizapp.ui.utils.TimeConverter
import com.andreisingeleytsev.playingquizapp.ui.utils.UIEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizScreenViewModel @Inject constructor(
    private val getQuizListUseCase: GetQuizListUseCase,
    private val getTimeFlowUseCase: GetTimeFlowUseCase,
    private val sendResultUseCase: SendResultUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _uiEvent = Channel<UIEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    private fun sendUIEvent(event: UIEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }

    fun onEvent(event: QuizScreenEvent) {
        when (event) {
            is QuizScreenEvent.OnBack -> {
                sendUIEvent(UIEvent.OnBack)
            }

            is QuizScreenEvent.OnChoseAnswer -> {
                _choseAnswer = event.index
            }

            is QuizScreenEvent.OnContinuePressed -> {
                if (choseAnswer.value != null) {
                    choseAnswer.value = null
                    answerTheQuestion(
                        if (_choseAnswer == _rightAnswer) AnswerResult.Correct
                        else AnswerResult.Incorrect
                    )
                    _choseAnswer = null
                } else {
                    if (_choseAnswer == null) answerTheQuestion(AnswerResult.Skipped)
                    else {
                        choseAnswer.value = _choseAnswer
                        rightAnswer.value = _rightAnswer
                    }
                }

            }
        }
    }

    fun formatTime(long: Long): String {
        return TimeConverter.invoke(long)
    }

    fun getProgressFloat(long: Long): Float {
        val totalTime = Constants.ROUND_TIME
        return 1f - (totalTime - long) / totalTime.toFloat()
    }

    private fun getQuestionItemWithShuffleList(questionItem: QuestionItem): QuestionItem {
        val list = questionItem.listOfAnswers.shuffled()
        return questionItem.copy(listOfAnswers = list)
    }

    private fun setNextQuestion() {
        if (_index.value == 19) {
            _index.value = -1
            sendUIEvent(UIEvent.OnNavigate(Routes.RESULT_SCREEN))
        }
        else {
            _index.value++
            list[_index.intValue].let {
                _currentQuestion.value = getQuestionItemWithShuffleList(it)
                _rightAnswer =
                    _currentQuestion.value?.listOfAnswers?.indexOf(it.listOfAnswers.first()) ?: 0
            }
        }
    }

    private fun answerTheQuestion(result: AnswerResult) {
        viewModelScope.launch {
            sendResultUseCase.invoke(result)
            setNextQuestion()
        }

        choseAnswer.value = null
        rightAnswer.value = null
    }

    private var _choseAnswer: Int? = null
    private var _rightAnswer: Int? = null
    val choseAnswer = mutableStateOf<Int?>(null)
    val rightAnswer = mutableStateOf<Int?>(null)


    var timeFlow = getTimeFlowUseCase.invoke()

    private var list = emptyList<QuestionItem>()

    private val _currentQuestion = mutableStateOf<QuestionItem?>(null)
    val currentQuestion: State<QuestionItem?> = _currentQuestion

    private val _index = mutableIntStateOf(-1)
    val index: State<Int> = _index

    init {
        viewModelScope.launch {
            savedStateHandle.get<String>(Constants.INDEX)?.toInt()?.let {
                getQuizListUseCase.invoke()[it].let { quizItem ->
                    list = quizItem.list.shuffled()
                }
            }
            _index.value = -1
            setNextQuestion()
        }
    }
}