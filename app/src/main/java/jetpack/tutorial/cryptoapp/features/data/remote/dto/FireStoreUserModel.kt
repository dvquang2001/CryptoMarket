package jetpack.tutorial.cryptoapp.features.data.remote.dto

import com.google.firebase.Timestamp
import jetpack.tutorial.cryptoapp.features.domain.model.UserDataModel
import jetpack.tutorial.cryptoapp.features.domain.model.UserStatus


data class FireStoreUserModel(
    val email: String? = null,
    val name: String? = null,
    val createdAt: Timestamp? = null,
    val status: String? = null,
) {

    fun transformStatusToModel(): UserStatus {
        return when(status) {
            "premium" -> UserStatus.Premium
            "trial" -> UserStatus.FreeTrial
            else -> UserStatus.FreeTrial
        }
    }
}

fun FireStoreUserModel.toModel(): UserDataModel {
    return UserDataModel(email = email, fullName = name, status = transformStatusToModel())
}