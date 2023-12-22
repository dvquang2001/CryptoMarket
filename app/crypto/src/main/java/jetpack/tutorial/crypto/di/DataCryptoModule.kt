package jetpack.tutorial.crypto.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import jetpack.tutorial.crypto.data.repository.CryptoRepositoryImpl
import jetpack.tutorial.crypto.domain.repository.CryptoRepository

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataCryptoModule {

    @Binds
    @ViewModelScoped
    abstract fun bindCryptoRepository(impl: CryptoRepositoryImpl): CryptoRepository
}