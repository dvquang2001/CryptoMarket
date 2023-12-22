package jetpack.tutorial.authentication.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jetpack.tutorial.authentication.data.repository.AuthManagerImpl
import jetpack.tutorial.authentication.domain.repository.AuthManager
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AuthManagerModule {

    @Binds
    @Singleton
    abstract fun bindAuthManager(authManagerImpl: AuthManagerImpl): AuthManager
}