package jetpack.tutorial.authentication.domain.usecase.register

import jetpack.tutorial.authentication.domain.payload.RegisterPayload
import jetpack.tutorial.authentication.domain.repository.AuthRepository
import jetpack.tutorial.libcore.networking.utils.ResultModel
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