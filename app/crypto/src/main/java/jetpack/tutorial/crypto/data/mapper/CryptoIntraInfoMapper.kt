package jetpack.tutorial.crypto.data.mapper

import jetpack.tutorial.crypto.data.remote.dto.CryptoIntraInfoDto
import jetpack.tutorial.crypto.domain.model.CryptoIntraInfoModel

fun CryptoIntraInfoDto.toCryptoIntraInfoModel(): CryptoIntraInfoModel {
    return CryptoIntraInfoModel(prices = prices)
}