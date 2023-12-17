package jetpack.tutorial.cryptoapp.features.auth.domain.payload

data class LoginPayload(
    val email: String,
    val password: String
)
