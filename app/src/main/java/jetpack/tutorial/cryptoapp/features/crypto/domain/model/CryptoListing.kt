package jetpack.tutorial.cryptoapp.features.crypto.domain.model

data class CryptoListing(
    val id: String,
    val symbol: String,
    val name: String,
    val image: String,
    val currentPrice: Int,
)
