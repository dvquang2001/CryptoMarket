package jetpack.tutorial.cryptoapp.features.auth.domain.payload

data class RegisterPayload(
    val fullName: String,
    val email: String,
    val password: String,
)
