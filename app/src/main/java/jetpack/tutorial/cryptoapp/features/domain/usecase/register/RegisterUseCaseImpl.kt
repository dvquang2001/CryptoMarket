package jetpack.tutorial.cryptoapp.features.domain.usecase.register

import jetpack.tutorial.cryptoapp.core.networking.utils.ResultModel
import jetpack.tutorial.cryptoapp.features.domain.payload.RegisterPayload
import jetpack.tutorial.cryptoapp.features.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RegisterUseCaseImpl @Inject constructor(
    private val authRepository: AuthRepository
) : RegisterUseCase{
    override fun execute(param: RegisterParam): Flow<ResultModel<Unit>> {
        val payload = RegisterPayload(
            fullName = param.fullName,
            email = param.email,
            password = param.password
        )
        return authRepository.registerWithEmailPassword(payload).map {
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