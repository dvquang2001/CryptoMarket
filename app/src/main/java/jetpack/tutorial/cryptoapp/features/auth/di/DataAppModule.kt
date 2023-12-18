package jetpack.tutorial.cryptoapp.features.auth.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import jetpack.tutorial.cryptoapp.features.auth.data.repository.FirebaseAuthRepository
import jetpack.tutorial.cryptoapp.features.auth.domain.repository.AuthRepository

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataAppModule {

    @Binds
    @ViewModelScoped
    abstract fun bindAuthDataSource(repository: FirebaseAuthRepository): AuthRepository
}