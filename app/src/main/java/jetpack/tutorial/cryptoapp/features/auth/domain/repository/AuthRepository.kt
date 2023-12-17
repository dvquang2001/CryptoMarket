package jetpack.tutorial.cryptoapp.features.auth.domain.repository

import jetpack.tutorial.cryptoapp.core.networking.utils.ResultModel
import jetpack.tutorial.cryptoapp.features.auth.domain.model.LoginModel
import jetpack.tutorial.cryptoapp.features.auth.domain.model.RegisterModel
import jetpack.tutorial.cryptoapp.features.auth.domain.model.UserDataModel
import jetpack.tutorial.cryptoapp.features.auth.domain.payload.LoginPayload
import jetpack.tutorial.cryptoapp.features.auth.domain.payload.RegisterPayload
import jetpack.tutorial.cryptoapp.features.auth.domain.usecase.reset_password.ResetPasswordParam
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    fun loginWithEmailPassword(payload: LoginPayload): Flow<ResultModel<LoginModel>>

    fun registerWithEmailPassword(payload: RegisterPayload): Flow<ResultModel<RegisterModel>>

    fun resetPassword(param: ResetPasswordParam): Flow<ResultModel<Boolean>>

    fun getUserInfo(): Flow<ResultModel<UserDataModel>>

    fun subscribeUserInfo()

    fun logout(): Flow<ResultModel<Boolean>>
}