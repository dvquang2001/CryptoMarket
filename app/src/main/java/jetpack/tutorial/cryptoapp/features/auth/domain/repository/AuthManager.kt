package jetpack.tutorial.cryptoapp.features.auth.domain.repository

import jetpack.tutorial.cryptoapp.features.auth.domain.model.AuthStateModel
import kotlinx.coroutines.flow.Flow

interface AuthManager {

    fun getAuthState(): Flow<AuthStateModel>
}