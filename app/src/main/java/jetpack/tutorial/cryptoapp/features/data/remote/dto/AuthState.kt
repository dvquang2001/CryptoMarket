package jetpack.tutorial.cryptoapp.features.data.remote.dto

import jetpack.tutorial.cryptoapp.features.domain.model.AuthStateModel

enum class AuthState {
    LOGGED_IN,
    LOGGED_OUT
}

fun AuthState?.toModel(): AuthStateModel {
    return when(this) {
        AuthState.LOGGED_IN -> AuthStateModel.LOGGED_IN
        AuthState.LOGGED_OUT -> AuthStateModel.LOGGED_OUT
        else -> AuthStateModel.LOGGED_OUT
    }
}
