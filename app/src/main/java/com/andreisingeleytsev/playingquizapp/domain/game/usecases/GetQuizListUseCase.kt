package com.andreisingeleytsev.playingquizapp.domain.game.usecases

import com.andreisingeleytsev.playingquizapp.data.game.model.QuizItem
import com.andreisingeleytsev.playingquizapp.domain.game.repository.GameRepository
import javax.inject.Inject

class GetQuizListUseCase@Inject constructor(
    private val repository: GameRepository
) {
    suspend operator fun invoke(): List<QuizItem>{
        return repository.getQuizList()
    }
}