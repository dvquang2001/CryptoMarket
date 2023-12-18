package jetpack.tutorial.cryptoapp.features.crypto.data.mapper

import jetpack.tutorial.cryptoapp.features.crypto.data.local.CryptoListingEntity
import jetpack.tutorial.cryptoapp.features.crypto.data.remote.dto.CryptoListingDto
import jetpack.tutorial.cryptoapp.features.crypto.domain.model.CryptoListingModel

fun CryptoListingDto.toCryptoListing(): CryptoListingModel {
    return CryptoListingModel(
        id, symbol, name, image, currentPrice, priceChangePercentage24h
    )
}

fun CryptoListingModel.toCryptoListingDto(): CryptoListingDto {
    return CryptoListingDto(
        id, symbol, name, image, currentPrice, priceChangePercentage24h
    )
}

fun CryptoListingModel.toCryptoListingEntity(): CryptoListingEntity {
    return CryptoListingEntity(
        id = id,
        symbol = symbol,
        name = name,
        image = image,
        currentPrice = currentPrice,
        priceChangePercentage24h = priceChangePercentage24h
    )
}

fun CryptoListingEntity.toCryptoListing(): CryptoListingModel {
    return CryptoListingModel(
        id, symbol, name, image, currentPrice, priceChangePercentage24h
    )
}