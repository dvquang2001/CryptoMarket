package jetpack.tutorial.cryptoapp.presentation.extentions

import jetpack.tutorial.crypto.domain.model.CryptoListingModel

fun List<CryptoListingModel>.toCryptoListingUI(): List<CryptoListingModel> {
    return this.map { crypto ->
        crypto.copy(priceChangePercentage24h = crypto.priceChangePercentage24h.roundBy2Numbers())
    }
}