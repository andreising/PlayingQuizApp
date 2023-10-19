package com.andreisingeleytsev.playingquizapp.domain.game.usecases

import com.andreisingeleytsev.playingquizapp.data.game.model.AnswerResult
import com.andreisingeleytsev.playingquizapp.domain.game.repository.GameRepository
import javax.inject.Inject

class SendResultUseCase @Inject constructor(
    private val repository: GameRepository
) {
    suspend operator fun invoke(result: AnswerResult){
        repository.sendResult(result)
    }
}