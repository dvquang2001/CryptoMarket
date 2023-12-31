package jetpack.tutorial.authentication.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import jetpack.tutorial.authentication.domain.usecase.login.LoginUseCaseImpl
import jetpack.tutorial.authentication.domain.usecase.auth_state.AuthStateUseCase
import jetpack.tutorial.authentication.domain.usecase.auth_state.AuthStateUseCaseImpl
import jetpack.tutorial.authentication.domain.usecase.get_user_info.GetUserInfoUseCase
import jetpack.tutorial.authentication.domain.usecase.get_user_info.GetUserInfoUseCaseImpl
import jetpack.tutorial.authentication.domain.usecase.login.LoginUseCase
import jetpack.tutorial.authentication.domain.usecase.logout.LogoutUseCase
import jetpack.tutorial.authentication.domain.usecase.logout.LogoutUseCaseImpl
import jetpack.tutorial.authentication.domain.usecase.register.RegisterUseCase
import jetpack.tutorial.authentication.domain.usecase.register.RegisterUseCaseImpl
import jetpack.tutorial.authentication.domain.usecase.reset_password.ResetPasswordUseCase
import jetpack.tutorial.authentication.domain.usecase.reset_password.ResetPasswordUseCaseImpl

@Module
@InstallIn(ViewModelComponent::class)
abstract class DomainAppModule {

    @Binds
    @ViewModelScoped
    abstract fun bindLoginUseCase(impl: LoginUseCaseImpl): LoginUseCase


    @Binds
    @ViewModelScoped
    abstract fun bindRegisterUseCase(impl: RegisterUseCaseImpl): RegisterUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindLogoutUseCase(impl: LogoutUseCaseImpl): LogoutUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindResetPasswordUseCase(impl: ResetPasswordUseCaseImpl): ResetPasswordUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindAuthStateUseCase(impl: AuthStateUseCaseImpl): AuthStateUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetUserInfoUseCase(impl: GetUserInfoUseCaseImpl): GetUserInfoUseCase
}