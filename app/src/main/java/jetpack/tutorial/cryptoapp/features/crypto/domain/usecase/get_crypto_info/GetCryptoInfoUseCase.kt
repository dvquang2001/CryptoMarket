package jetpack.tutorial.cryptoapp.features.crypto.domain.usecase.get_crypto_info

import jetpack.tutorial.cryptoapp.core.networking.utils.FlowResultUseCase
import jetpack.tutorial.cryptoapp.features.crypto.domain.model.CryptoInfoModel

interface GetCryptoInfoUseCase : FlowResultUseCase<CryptoInfoParam, CryptoInfoModel>