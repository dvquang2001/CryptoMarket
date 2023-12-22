package jetpack.tutorial.authentication.domain.usecase.register

import jetpack.tutorial.libcore.networking.utils.FlowResultUseCase

interface RegisterUseCase: FlowResultUseCase<RegisterParam, Unit>