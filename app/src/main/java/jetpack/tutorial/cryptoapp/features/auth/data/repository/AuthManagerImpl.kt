package jetpack.tutorial.cryptoapp.features.auth.data.repository

import com.google.firebase.auth.FirebaseAuth
import jetpack.tutorial.cryptoapp.features.auth.data.remote.dto.toModel
import jetpack.tutorial.cryptoapp.features.auth.domain.model.AuthStateModel
import jetpack.tutorial.cryptoapp.features.auth.domain.repository.AuthManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AuthManagerImpl @Inject constructor(
    private val auth: FirebaseAuth
): AuthManager {

    private val authStateSharedFlow: MutableSharedFlow<jetpack.tutorial.cryptoapp.features.auth.data.remote.dto.AuthState> = MutableSharedFlow(replay = 1)

    init {
        subscribeFirebaseAuthState()
    }

    private fun subscribeFirebaseAuthState() {
        auth.addAuthStateListener {
            if(it.currentUser != null) {
                authStateSharedFlow.tryEmit(jetpack.tutorial.cryptoapp.features.auth.data.remote.dto.AuthState.LOGGED_IN)
            } else {
                authStateSharedFlow.tryEmit(jetpack.tutorial.cryptoapp.features.auth.data.remote.dto.AuthState.LOGGED_OUT)
            }
        }
    }

    override fun getAuthState(): Flow<AuthStateModel> {
        return flow {
            emitAll(authStateSharedFlow.map { it.toModel() })
        }
    }


}