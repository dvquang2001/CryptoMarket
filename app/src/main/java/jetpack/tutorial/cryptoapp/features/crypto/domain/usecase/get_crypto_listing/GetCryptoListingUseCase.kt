package jetpack.tutorial.cryptoapp.features.crypto.domain.usecase.get_crypto_listing

import jetpack.tutorial.cryptoapp.core.networking.utils.FlowResultUseCase
import jetpack.tutorial.cryptoapp.features.crypto.domain.model.CryptoListingModel

interface GetCryptoListingUseCase: FlowResultUseCase<CryptoListingParam, List<CryptoListingModel>>