package com.andreisingeleytsev.playingquizapp.domain.game.repository

import com.andreisingeleytsev.playingquizapp.data.game.model.AnswerResult
import com.andreisingeleytsev.playingquizapp.data.game.model.QuestionItem
import com.andreisingeleytsev.playingquizapp.data.game.model.QuizItem
import kotlinx.coroutines.flow.Flow


interface GameRepository {
    suspend fun getQuizList(): List<QuizItem>
    fun getTime(): Flow<Long>
    suspend fun sendResult(result: AnswerResult)
    suspend fun getResultList(): List<AnswerResult>
}