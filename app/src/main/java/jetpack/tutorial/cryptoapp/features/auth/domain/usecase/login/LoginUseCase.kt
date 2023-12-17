package jetpack.tutorial.cryptoapp.features.auth.domain.usecase.login

import jetpack.tutorial.cryptoapp.core.networking.utils.FlowResultUseCase

interface LoginUseCase: FlowResultUseCase<LoginParam, Unit>