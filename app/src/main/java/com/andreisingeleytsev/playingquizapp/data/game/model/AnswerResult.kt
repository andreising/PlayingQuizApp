package com.andreisingeleytsev.playingquizapp.data.game.model

sealed class AnswerResult{
    data object Incorrect: AnswerResult()
    data object Skipped: AnswerResult()
    data object Correct: AnswerResult()
}
