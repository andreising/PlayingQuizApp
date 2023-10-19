package com.andreisingeleytsev.playingquizapp.ui.screens.quiz_screen

sealed class QuizScreenEvent{
    data object OnContinuePressed: QuizScreenEvent()
    data class OnChoseAnswer(val index: Int?): QuizScreenEvent()
    data object OnBack: QuizScreenEvent()
}
