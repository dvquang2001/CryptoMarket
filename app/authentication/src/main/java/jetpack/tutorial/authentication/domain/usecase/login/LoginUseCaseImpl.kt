package jetpack.tutorial.authentication.domain.usecase.login

import jetpack.tutorial.authentication.domain.payload.LoginPayload
import jetpack.tutorial.authentication.domain.repository.AuthRepository
import jetpack.tutorial.libcore.networking.utils.ResultModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LoginUseCaseImpl @Inject constructor(
    private val authRepository: AuthRepository
) : LoginUseCase{
    override fun execute(param: LoginParam): Flow<ResultModel<Unit>> {
        val payload = LoginPayload(email = param.email, password = param.password)
        return authRepository.loginWithEmailPassword(payload).map {
            when(it) {
                is ResultModel.Success -> {
                    ResultModel.Success(Unit)
                }

                is ResultModel.Error -> {
                    ResultModel.Error(it.t)
                }

                else -> {
                    ResultModel.Error(t = UnknownError())
                }
            }
        }
    }
}