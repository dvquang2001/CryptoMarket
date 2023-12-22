package jetpack.tutorial.crypto.domain.usecase.get_crypto_info

import jetpack.tutorial.crypto.domain.model.CryptoInfoModel
import jetpack.tutorial.libcore.networking.utils.FlowResultUseCase

interface GetCryptoInfoUseCase : FlowResultUseCase<CryptoInfoParam, CryptoInfoModel>