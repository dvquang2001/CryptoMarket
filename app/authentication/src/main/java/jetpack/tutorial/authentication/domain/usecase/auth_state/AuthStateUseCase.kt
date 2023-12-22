package jetpack.tutorial.authentication.domain.usecase.auth_state

import jetpack.tutorial.authentication.domain.model.AuthStateModel
import jetpack.tutorial.libcore.networking.utils.FlowResultUseCase

interface AuthStateUseCase: FlowResultUseCase<Any, AuthStateModel>