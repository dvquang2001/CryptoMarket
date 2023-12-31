package jetpack.tutorial.crypto.domain.model

data class CryptoListingModel(
    val id: String,
    val symbol: String,
    val name: String,
    val image: String,
    val currentPrice: Double,
    val priceChangePercentage24h: Double,
)
