package jetpack.tutorial.crypto.data.remote.dto

import com.squareup.moshi.Json
import jetpack.tutorial.crypto.data.remote.dto.market_data.MarketData

data class CryptoInfoDto(
    @field:Json(name = "id") val id: String,
    @field:Json(name = "symbol") val symbol: String,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "image") val image: Image,
    @field:Json(name = "current_price") val currentPrice: Double,
    @field:Json(name = "market_data") val marketData: MarketData?,
)