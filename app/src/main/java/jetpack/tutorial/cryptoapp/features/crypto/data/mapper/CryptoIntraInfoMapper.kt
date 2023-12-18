package jetpack.tutorial.cryptoapp.features.crypto.data.mapper

import jetpack.tutorial.cryptoapp.features.crypto.data.remote.dto.CryptoIntraInfoDto
import jetpack.tutorial.cryptoapp.features.crypto.domain.model.CryptoIntraInfoModel

fun CryptoIntraInfoDto.toCryptoIntraInfoModel(): CryptoIntraInfoModel {
    return CryptoIntraInfoModel(prices = prices)
}