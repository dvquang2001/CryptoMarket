package jetpack.tutorial.authentication.domain.repository

import jetpack.tutorial.authentication.domain.model.LoginModel
import jetpack.tutorial.authentication.domain.model.RegisterModel
import jetpack.tutorial.authentication.domain.model.UserDataModel
import jetpack.tutorial.authentication.domain.payload.LoginPayload
import jetpack.tutorial.authentication.domain.payload.RegisterPayload
import jetpack.tutorial.authentication.domain.usecase.reset_password.ResetPasswordParam
import jetpack.tutorial.libcore.networking.utils.ResultModel
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    fun loginWithEmailPassword(payload: LoginPayload): Flow<ResultModel<LoginModel>>

    fun registerWithEmailPassword(payload: RegisterPayload): Flow<ResultModel<RegisterModel>>

    fun resetPassword(param: ResetPasswordParam): Flow<ResultModel<Boolean>>

    fun getUserInfo(): Flow<ResultModel<UserDataModel>>

    fun subscribeUserInfo()

    fun logout(): Flow<ResultModel<Boolean>>
}