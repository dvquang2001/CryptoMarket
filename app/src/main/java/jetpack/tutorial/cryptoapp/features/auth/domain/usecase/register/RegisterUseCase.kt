package jetpack.tutorial.cryptoapp.features.auth.domain.usecase.register

import jetpack.tutorial.cryptoapp.core.networking.utils.FlowResultUseCase

interface RegisterUseCase: FlowResultUseCase<RegisterParam, Unit>