package jetpack.tutorial.authentication.domain.usecase.auth_state

import jetpack.tutorial.authentication.domain.model.AuthStateModel
import jetpack.tutorial.authentication.domain.repository.AuthManager
import jetpack.tutorial.libcore.networking.utils.ResultModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AuthStateUseCaseImpl @Inject constructor(
    private val authManager: AuthManager
) : AuthStateUseCase{
    override fun execute(param: Any): Flow<ResultModel<AuthStateModel>> {
        return authManager.getAuthState().map {
            ResultModel.Success(it)
        }
    }
}