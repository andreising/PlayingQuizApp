package com.andreisingeleytsev.playingquizapp.ui.screens.result_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andreisingeleytsev.playingquizapp.data.game.model.AnswerResult
import com.andreisingeleytsev.playingquizapp.domain.game.usecases.GetResultUseCase
import com.andreisingeleytsev.playingquizapp.ui.screens.quiz_screen.QuizScreenEvent
import com.andreisingeleytsev.playingquizapp.ui.utils.UIEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResultScreenViewModel @Inject constructor(
    private val getResultUseCase: GetResultUseCase
): ViewModel() {
    private val _uiEvent = Channel<UIEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    private fun sendUIEvent(event: UIEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }

    fun onEvent(event: ResultScreenEvent) {
        when (event) {
            is ResultScreenEvent.OnBack -> {
                sendUIEvent(UIEvent.OnBack)
                sendUIEvent(UIEvent.OnBack)
            }
            is ResultScreenEvent.OnRestart -> {
                sendUIEvent(UIEvent.OnBack)
            }
        }
    }

    val resultList = mutableStateOf(emptyList<AnswerResult>())

    fun getCount(answerResult: AnswerResult?): Int{
        if (answerResult==null) return 20
        var count = 0
        resultList.value.forEach {
            if (it == answerResult) count++
        }
        return count
    }

    init {
        viewModelScope.launch {
            resultList.value = getResultUseCase.invoke()
        }
    }
}