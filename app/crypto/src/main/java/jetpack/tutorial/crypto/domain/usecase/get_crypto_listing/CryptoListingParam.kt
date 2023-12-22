package jetpack.tutorial.crypto.domain.usecase.get_crypto_listing

data class CryptoListingParam(
    val fetchFromRemote: Boolean,
    val query: String
)
