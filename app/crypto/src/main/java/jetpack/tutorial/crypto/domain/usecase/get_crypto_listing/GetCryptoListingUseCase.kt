package jetpack.tutorial.crypto.domain.usecase.get_crypto_listing

import jetpack.tutorial.crypto.domain.model.CryptoListingModel
import jetpack.tutorial.libcore.networking.utils.FlowResultUseCase

interface GetCryptoListingUseCase: FlowResultUseCase<CryptoListingParam, List<CryptoListingModel>>