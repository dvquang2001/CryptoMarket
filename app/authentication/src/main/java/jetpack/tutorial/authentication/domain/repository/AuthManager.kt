package jetpack.tutorial.authentication.domain.repository

import jetpack.tutorial.authentication.domain.model.AuthStateModel
import kotlinx.coroutines.flow.Flow

interface AuthManager {

    fun getAuthState(): Flow<AuthStateModel>
}