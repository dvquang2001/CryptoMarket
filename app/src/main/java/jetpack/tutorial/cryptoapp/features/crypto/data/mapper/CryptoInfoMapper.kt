package jetpack.tutorial.cryptoapp.features.crypto.data.mapper

import jetpack.tutorial.cryptoapp.features.crypto.data.remote.dto.CryptoInfoDto
import jetpack.tutorial.cryptoapp.features.crypto.domain.model.CryptoInfo

fun CryptoInfoDto.toCryptoInfo(): CryptoInfo {
    return CryptoInfo(
        id,
        symbol,
        name,
        image,
        currentPrice,
        marketCap,
        marketCapRank,
        fullyDilutedValuation,
        totalVolume,
        high24h,
        low24h,
        priceChange24h,
        priceChangePercentage24h,
        marketCapChange24h,
        marketCapChangePercentage24h,
        circulatingSupply,
        totalSupply,
        maxSupply,
        ath,
        athChangePercentage,
        athDate,
        atl,
        atlChangePercentage,
        atlDate,
        roi,
        lastUpdated
    )
}

fun CryptoInfo.toCryptoInfoDto(): CryptoInfoDto {
    return CryptoInfoDto(
        id,
        symbol,
        name,
        image,
        currentPrice,
        marketCap,
        marketCapRank,
        fullyDilutedValuation,
        totalVolume,
        high24h,
        low24h,
        priceChange24h,
        priceChangePercentage24h,
        marketCapChange24h,
        marketCapChangePercentage24h,
        circulatingSupply,
        totalSupply,
        maxSupply,
        ath,
        athChangePercentage,
        athDate,
        atl,
        atlChangePercentage,
        atlDate,
        roi,
        lastUpdated
    )
}