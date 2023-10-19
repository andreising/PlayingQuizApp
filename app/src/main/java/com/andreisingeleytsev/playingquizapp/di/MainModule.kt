package com.andreisingeleytsev.playingquizapp.di

import android.content.Context
import com.andreisingeleytsev.playingquizapp.data.datastore.DataStoreHub
import com.andreisingeleytsev.listeningmeditationapp.domain.repository.OnboardStateRepository
import com.andreisingeleytsev.playingquizapp.data.datastore.repository.OnBoardStateRepositoryImpl
import com.andreisingeleytsev.playingquizapp.data.game.GameManager
import com.andreisingeleytsev.playingquizapp.domain.game.repository.GameRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {
    @Provides
    @Singleton
    fun provideDataStoreHub(
        @ApplicationContext context: Context
    ) = DataStoreHub(context = context)

    @Provides
    @Singleton
    fun provideOnBoardStateRepository(dataStoreHub: DataStoreHub): OnboardStateRepository {
        return OnBoardStateRepositoryImpl(dataStoreHub)
    }

    @Provides
    @Singleton
    fun provideGameRepository(): GameRepository = GameManager()
}