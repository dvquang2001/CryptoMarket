package jetpack.tutorial.authentication.domain.usecase.get_user_info

import jetpack.tutorial.authentication.domain.model.UserDataModel
import jetpack.tutorial.authentication.domain.repository.AuthRepository
import jetpack.tutorial.libcore.networking.utils.ResultModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserInfoUseCaseImpl @Inject constructor(
    private val authRepository: AuthRepository
) : GetUserInfoUseCase{
    override fun execute(param: Any): Flow<ResultModel<UserDataModel>> {
        return authRepository.getUserInfo()
    }
}