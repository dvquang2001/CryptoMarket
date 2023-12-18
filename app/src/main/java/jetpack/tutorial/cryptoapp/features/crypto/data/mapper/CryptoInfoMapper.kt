package jetpack.tutorial.cryptoapp.features.crypto.data.mapper

import jetpack.tutorial.cryptoapp.features.crypto.data.remote.dto.CryptoInfoDto
import jetpack.tutorial.cryptoapp.features.crypto.domain.model.CryptoInfoModel

fun CryptoInfoDto.toCryptoInfo(): CryptoInfoModel {
    return CryptoInfoModel(
        id,
        symbol,
        name,
        image.thumb,
        currentPrice,
    )
}