package jetpack.tutorial.cryptoapp.features.domain.usecase.register

import jetpack.tutorial.cryptoapp.core.networking.utils.FlowResultUseCase

interface RegisterUseCase: FlowResultUseCase<RegisterParam, Unit>