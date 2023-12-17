package jetpack.tutorial.cryptoapp.features.crypto.data.mapper

import jetpack.tutorial.cryptoapp.features.crypto.data.local.CryptoListingEntity
import jetpack.tutorial.cryptoapp.features.crypto.data.remote.dto.CryptoListingDto
import jetpack.tutorial.cryptoapp.features.crypto.domain.model.CryptoListing

fun CryptoListingDto.toCryptoListing(): CryptoListing {
    return CryptoListing(
        id, symbol, name, image, currentPrice
    )
}

fun CryptoListing.toCryptoListingDto(): CryptoListingDto {
    return CryptoListingDto(
        id, symbol, name, image, currentPrice
    )
}

fun CryptoListing.toCryptoListingEntity(): CryptoListingEntity {
    return CryptoListingEntity(
        id = id,
        symbol = symbol,
        name = name,
        image = image,
        currentPrice = currentPrice
    )
}