package jetpack.tutorial.cryptoapp.features.auth.domain.usecase.auth_state

import jetpack.tutorial.cryptoapp.core.networking.utils.FlowResultUseCase
import jetpack.tutorial.cryptoapp.features.auth.domain.model.AuthStateModel

interface AuthStateUseCase: FlowResultUseCase<Any, AuthStateModel>