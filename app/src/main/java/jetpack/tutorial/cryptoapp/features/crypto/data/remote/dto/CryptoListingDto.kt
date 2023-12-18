package jetpack.tutorial.cryptoapp.features.crypto.data.remote.dto

import com.squareup.moshi.Json

data class CryptoListingDto(
    @field:Json(name = "id") val id: String,
    @field:Json(name = "symbol") val symbol: String,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "image") val image: String,
    @field:Json(name = "current_price") val currentPrice: Double,
)
