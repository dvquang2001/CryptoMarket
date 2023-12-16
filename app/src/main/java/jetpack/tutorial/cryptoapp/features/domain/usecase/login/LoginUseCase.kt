package jetpack.tutorial.cryptoapp.features.domain.usecase.login

import jetpack.tutorial.cryptoapp.core.networking.utils.FlowResultUseCase

interface LoginUseCase: FlowResultUseCase<LoginParam, Unit>