package jetpack.tutorial.cryptoapp.features.crypto.domain.model

data class CryptoInfoModel(
    val id: String,
    val symbol: String,
    val name: String,
    val image: String,
    val currentPrice: Int,
    val marketCap: Long,
    val marketCapRank: Int,
    val fullyDilutedValuation: Long,
    val totalVolume: Long,
    val high24h: Int,
    val low24h: Int,
    val priceChange24h: Double,
    val priceChangePercentage24h: Double,
    val marketCapChange24h: Double,
    val marketCapChangePercentage24h: Double,
    val circulatingSupply: Double,
    val totalSupply: Double,
    val maxSupply: Double,
    val ath: Int,
    val athChangePercentage: Double,
    val athDate: String,
    val atl: Double,
    val atlChangePercentage: Double,
    val atlDate: String,
    val roi: Any,
    val lastUpdated: String
)

