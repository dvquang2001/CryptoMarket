package jetpack.tutorial.cryptoapp.features.auth.domain.usecase.reset_password

import jetpack.tutorial.cryptoapp.core.networking.utils.ResultModel
import jetpack.tutorial.cryptoapp.features.auth.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ResetPasswordUseCaseImpl @Inject constructor(
    private val authRepository: AuthRepository
) : ResetPasswordUseCase{
    override fun execute(param: ResetPasswordParam): Flow<ResultModel<Unit>> {
        return authRepository.resetPassword(param).map {
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