package jetpack.tutorial.authentication.domain.usecase.logout

import jetpack.tutorial.authentication.domain.repository.AuthRepository
import jetpack.tutorial.libcore.networking.utils.ResultModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LogoutUseCaseImpl @Inject constructor(
    private val authRepository: AuthRepository
) : LogoutUseCase {
    override fun execute(param: Any): Flow<ResultModel<Unit>> {
        return authRepository.logout().map {
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