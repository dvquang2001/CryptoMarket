package jetpack.tutorial.cryptoapp.features.auth.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jetpack.tutorial.cryptoapp.features.auth.data.repository.AuthManagerImpl
import jetpack.tutorial.cryptoapp.features.auth.domain.repository.AuthManager
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AuthManagerModule {

    @Binds
    @Singleton
    abstract fun bindAuthManager(authManagerImpl: AuthManagerImpl): AuthManager
}