package jetpack.tutorial.crypto.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import jetpack.tutorial.crypto.domain.usecase.get_crypto_info.GetCryptoInfoUseCase
import jetpack.tutorial.crypto.domain.usecase.get_crypto_info.GetCryptoInfoUseCaseImpl
import jetpack.tutorial.crypto.domain.usecase.get_crypto_intra_info.GetCryptoIntraInfoUseCase
import jetpack.tutorial.crypto.domain.usecase.get_crypto_intra_info.GetCryptoIntraInfoUseCaseImpl
import jetpack.tutorial.crypto.domain.usecase.get_crypto_listing.GetCryptoListingUseCase
import jetpack.tutorial.crypto.domain.usecase.get_crypto_listing.GetCryptoListingUseCaseImpl

@Module
@InstallIn(ViewModelComponent::class)
abstract class DomainCryptoModule {

    @Binds
    @ViewModelScoped
    abstract fun bindGetCryptoListingUseCase(impl: GetCryptoListingUseCaseImpl): GetCryptoListingUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetCryptoInfoUseCas(impl: GetCryptoInfoUseCaseImpl): GetCryptoInfoUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetCryptoIntraInfoUseCase(impl: GetCryptoIntraInfoUseCaseImpl): GetCryptoIntraInfoUseCase
}