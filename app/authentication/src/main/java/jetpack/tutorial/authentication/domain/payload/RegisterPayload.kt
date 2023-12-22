package jetpack.tutorial.authentication.domain.payload

data class RegisterPayload(
    val fullName: String,
    val email: String,
    val password: String,
)
