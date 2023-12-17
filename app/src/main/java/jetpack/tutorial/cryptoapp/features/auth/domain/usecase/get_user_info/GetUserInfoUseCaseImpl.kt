package jetpack.tutorial.cryptoapp.features.auth.domain.usecase.get_user_info

import jetpack.tutorial.cryptoapp.core.networking.utils.ResultModel
import jetpack.tutorial.cryptoapp.features.auth.domain.model.UserDataModel
import jetpack.tutorial.cryptoapp.features.auth.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserInfoUseCaseImpl @Inject constructor(
    private val authRepository: AuthRepository
) : GetUserInfoUseCase{
    override fun execute(param: Any): Flow<ResultModel<UserDataModel>> {
        return authRepository.getUserInfo()
    }
}