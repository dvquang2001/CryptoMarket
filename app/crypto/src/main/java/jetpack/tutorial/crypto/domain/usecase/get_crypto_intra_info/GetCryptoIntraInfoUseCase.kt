package jetpack.tutorial.crypto.domain.usecase.get_crypto_intra_info

import jetpack.tutorial.crypto.domain.model.CryptoIntraInfoModel
import jetpack.tutorial.libcore.networking.utils.FlowResultUseCase

interface GetCryptoIntraInfoUseCase: FlowResultUseCase<CryptoIntraInfoParam, CryptoIntraInfoModel>