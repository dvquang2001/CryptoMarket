package jetpack.tutorial.cryptoapp.features.crypto.data.remote.dto

import com.squareup.moshi.Json

data class CryptoInfoDto(
    @field:Json(name = "id") val id: String,
    @field:Json(name = "symbol") val symbol: String,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "image") val image: String,
    @field:Json(name = "current_price") val currentPrice: Int,
    @field:Json(name = "market_cap") val marketCap: Long,
    @field:Json(name = "market_cap_rank") val marketCapRank: Int,
    @field:Json(name = "fully_diluted_valuation") val fullyDilutedValuation: Long,
    @field:Json(name = "total_volume") val totalVolume: Long,
    @field:Json(name = "high_24h") val high24h: Int,
    @field:Json(name = "low_24h") val low24h: Int,
    @field:Json(name = "price_change_24h") val priceChange24h: Double,
    @field:Json(name = "price_change_percentage_24h") val priceChangePercentage24h: Double,
    @field:Json(name = "market_cap_change_24h") val marketCapChange24h: Double,
    @field:Json(name = "market_cap_change_percentage_24h") val marketCapChangePercentage24h: Double,
    @field:Json(name = "circulating_supply") val circulatingSupply: Double,
    @field:Json(name = "total_supply") val totalSupply: Double,
    @field:Json(name = "max_supply") val maxSupply: Double,
    @field:Json(name = "ath") val ath: Int,
    @field:Json(name = "ath_change_percentage") val athChangePercentage: Double,
    @field:Json(name = "ath_date") val athDate: String,
    @field:Json(name = "atl") val atl: Double,
    @field:Json(name = "atl_change_percentage") val atlChangePercentage: Double,
    @field:Json(name = "atl_date") val atlDate: String,
    @field:Json(name = "roi") val roi: Any,
    @field:Json(name = "last_updated") val lastUpdated: String
)