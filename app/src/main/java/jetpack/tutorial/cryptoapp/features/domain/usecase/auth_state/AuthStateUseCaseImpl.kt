package jetpack.tutorial.cryptoapp.features.domain.usecase.auth_state

import jetpack.tutorial.cryptoapp.core.networking.utils.ResultModel
import jetpack.tutorial.cryptoapp.features.domain.model.AuthStateModel
import jetpack.tutorial.cryptoapp.features.domain.repository.AuthManager
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