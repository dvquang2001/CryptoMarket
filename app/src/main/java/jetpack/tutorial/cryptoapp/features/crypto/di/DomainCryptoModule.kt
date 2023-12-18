package jetpack.tutorial.cryptoapp.features.crypto.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import jetpack.tutorial.cryptoapp.features.crypto.domain.usecase.get_crypto_info.GetCryptoInfoUseCase
import jetpack.tutorial.cryptoapp.features.crypto.domain.usecase.get_crypto_info.GetCryptoInfoUseCaseImpl
import jetpack.tutorial.cryptoapp.features.crypto.domain.usecase.get_crypto_listing.GetCryptoListingUseCase
import jetpack.tutorial.cryptoapp.features.crypto.domain.usecase.get_crypto_listing.GetCryptoListingUseCaseImpl

@Module
@InstallIn(ViewModelComponent::class)
abstract class DomainCryptoModule {

    @Binds
    @ViewModelScoped
    abstract fun bindGetCryptoListingUseCase(impl: GetCryptoListingUseCaseImpl): GetCryptoListingUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetCryptoInfoUseCas(impl: GetCryptoInfoUseCaseImpl): GetCryptoInfoUseCase


}