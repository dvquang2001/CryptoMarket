package jetpack.tutorial.cryptoapp.features.crypto.domain.model

data class CryptoIntraInfoModel(
   val prices: List<List<Double>>
)

fun CryptoIntraInfoModel.convertToListPairData(): List<PairData> {
    return prices.map { pair ->
        PairData(timeLong = pair[0], price = pair[1])
    }
}

data class PairData(
    val timeLong: Double? = null,
    val price: Double? = null
) {

    override fun toString(): String {
        return "Time: $timeLong - Price: $price"
    }
}