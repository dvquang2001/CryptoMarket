package jetpack.tutorial.cryptoapp.features.domain.usecase.auth_state

import jetpack.tutorial.cryptoapp.core.networking.utils.FlowResultUseCase
import jetpack.tutorial.cryptoapp.features.di.AuthManagerModule
import jetpack.tutorial.cryptoapp.features.domain.model.AuthStateModel

interface AuthStateUseCase: FlowResultUseCase<Any, AuthStateModel>