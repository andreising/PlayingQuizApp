package com.andreisingeleytsev.playingquizapp.data.datastore.repository

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import com.andreisingeleytsev.playingquizapp.data.datastore.DataStoreHub
import com.andreisingeleytsev.listeningmeditationapp.domain.repository.OnboardStateRepository
import com.andreisingeleytsev.playingquizapp.common.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

class OnBoardStateRepositoryImpl(private val dataStoreHub: DataStoreHub): OnboardStateRepository {

    private object PreferencesKeys {
        val onBoardingKey = booleanPreferencesKey(name = Constants.ONBOARD_KEY)
    }

    override suspend fun onFinishedSave() {

        dataStoreHub.dataStore.edit{ preferences ->
            preferences[PreferencesKeys.onBoardingKey] = true
        }
    }

    override fun getOnboardState(): Flow<Boolean> {
        return dataStoreHub.dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                val onBoardingState = preferences[PreferencesKeys.onBoardingKey] ?: false
                onBoardingState
            }
    }
}