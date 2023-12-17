package jetpack.tutorial.cryptoapp.features.auth.domain.model

data class UserDataModel(
    val email: String? = "",
    val fullName: String? = "",
    val status: UserStatus
)

enum class UserStatus {
    Premium,
    FreeTrial
}
