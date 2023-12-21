package jetpack.tutorial.cryptoapp.features.crypto.domain.model

data class CryptoInfoModel(
    val id: String,
    val symbol: String,
    val name: String,
    val imageThumb: String,
    val imageSmall: String,
    val imageLarge: String,
    val currentPrice: Double,
    val totalVolume: Long,
)

