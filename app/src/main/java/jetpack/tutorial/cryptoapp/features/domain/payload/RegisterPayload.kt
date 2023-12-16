package jetpack.tutorial.cryptoapp.features.domain.payload

data class RegisterPayload(
    val fullName: String,
    val email: String,
    val password: String,
)
