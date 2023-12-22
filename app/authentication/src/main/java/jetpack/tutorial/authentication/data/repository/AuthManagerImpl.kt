package jetpack.tutorial.authentication.data.repository

import com.google.firebase.auth.FirebaseAuth
import jetpack.tutorial.authentication.data.remote.dto.AuthState
import jetpack.tutorial.authentication.data.remote.dto.toModel
import jetpack.tutorial.authentication.domain.model.AuthStateModel
import jetpack.tutorial.authentication.domain.repository.AuthManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AuthManagerImpl @Inject constructor(
    private val auth: FirebaseAuth
): AuthManager {

    private val authStateSharedFlow: MutableSharedFlow<AuthState> = MutableSharedFlow(replay = 1)

    init {
        subscribeFirebaseAuthState()
    }

    private fun subscribeFirebaseAuthState() {
        auth.addAuthStateListener {
            if(it.currentUser != null) {
                authStateSharedFlow.tryEmit(AuthState.LOGGED_IN)
            } else {
                authStateSharedFlow.tryEmit(AuthState.LOGGED_OUT)
            }
        }
    }

    override fun getAuthState(): Flow<AuthStateModel> {
        return flow {
            emitAll(authStateSharedFlow.map { it.toModel() })
        }
    }


}