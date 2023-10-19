package com.andreisingeleytsev.playingquizapp.data.game

import android.os.CountDownTimer
import com.andreisingeleytsev.playingquizapp.common.Constants
import com.andreisingeleytsev.playingquizapp.data.game.model.AnswerResult
import com.andreisingeleytsev.playingquizapp.data.game.model.QuestionItem
import com.andreisingeleytsev.playingquizapp.data.game.model.QuizItem
import com.andreisingeleytsev.playingquizapp.domain.game.repository.GameRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GameManager(): GameRepository {
    override suspend fun getQuizList(): List<QuizItem> {
        return quizList
    }

    override fun getTime(): Flow<Long> = flow {
        var seconds = Constants.ROUND_TIME
        while (true) {
            emit(seconds)
            delay(1000)
            seconds-=1000L
        }
    }

    override suspend fun sendResult(result: AnswerResult) {
        resultList.add(result)
    }

    override suspend fun getResultList(): List<AnswerResult> {
        return resultList
    }

    private val quizList = listOf(
        QuizItem.CinemaQuizItem,
        QuizItem.GeographyQuizItem,
        QuizItem.HistoryQuizItem
    )

    private val resultList = mutableListOf<AnswerResult>()

}