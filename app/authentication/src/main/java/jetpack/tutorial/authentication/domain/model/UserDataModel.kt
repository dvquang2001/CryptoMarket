package jetpack.tutorial.authentication.domain.model

data class UserDataModel(
    val email: String? = "",
    val fullName: String? = "",
    val status: UserStatus
)

enum class UserStatus {
    Premium,
    FreeTrial
}
