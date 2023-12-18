package jetpack.tutorial.cryptoapp.features.crypto.domain.model

data class CryptoInfoModel(
    val id: String,
    val symbol: String,
    val name: String,
    val image: String,
    val currentPrice: Double,
)

