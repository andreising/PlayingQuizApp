package com.andreisingeleytsev.playingquizapp.domain.game.usecases

import com.andreisingeleytsev.playingquizapp.domain.game.repository.GameRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetTimeFlowUseCase @Inject constructor(
    private val repository: GameRepository
)  {
    operator fun invoke():Flow<Long>{
        return repository.getTime()
    }
}