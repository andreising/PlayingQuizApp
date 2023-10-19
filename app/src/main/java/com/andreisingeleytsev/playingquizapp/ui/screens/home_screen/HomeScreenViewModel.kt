package com.andreisingeleytsev.playingquizapp.ui.screens.home_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andreisingeleytsev.playingquizapp.data.game.model.QuizItem
import com.andreisingeleytsev.playingquizapp.domain.game.usecases.GetQuizListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val useCase: GetQuizListUseCase
): ViewModel() {
    var list = emptyList<QuizItem>()

    init {
        viewModelScope.launch {
            list = useCase.invoke()
        }
    }
}