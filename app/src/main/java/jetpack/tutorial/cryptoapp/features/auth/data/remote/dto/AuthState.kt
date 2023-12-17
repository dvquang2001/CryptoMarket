package jetpack.tutorial.cryptoapp.features.auth.data.remote.dto

import jetpack.tutorial.cryptoapp.features.auth.domain.model.AuthStateModel

enum class AuthState {
    LOGGED_IN,
    LOGGED_OUT
}

fun jetpack.tutorial.cryptoapp.features.auth.data.remote.dto.AuthState?.toModel(): AuthStateModel {
    return when(this) {
        jetpack.tutorial.cryptoapp.features.auth.data.remote.dto.AuthState.LOGGED_IN -> AuthStateModel.LOGGED_IN
        jetpack.tutorial.cryptoapp.features.auth.data.remote.dto.AuthState.LOGGED_OUT -> AuthStateModel.LOGGED_OUT
        else -> AuthStateModel.LOGGED_OUT
    }
}
