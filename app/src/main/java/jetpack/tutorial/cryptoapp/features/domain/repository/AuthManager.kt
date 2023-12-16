package jetpack.tutorial.cryptoapp.features.domain.repository

import jetpack.tutorial.cryptoapp.features.domain.model.AuthStateModel
import kotlinx.coroutines.flow.Flow

interface AuthManager {

    fun getAuthState(): Flow<AuthStateModel>
}