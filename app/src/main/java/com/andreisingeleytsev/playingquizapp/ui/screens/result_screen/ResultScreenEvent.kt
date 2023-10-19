package com.andreisingeleytsev.playingquizapp.ui.screens.result_screen

import com.andreisingeleytsev.playingquizapp.ui.screens.quiz_screen.QuizScreenEvent

sealed class ResultScreenEvent{
    data object OnBack: ResultScreenEvent()
    data object OnRestart: ResultScreenEvent()
}
