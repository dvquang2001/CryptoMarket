package jetpack.tutorial.authentication.domain.usecase.login

import jetpack.tutorial.libcore.networking.utils.FlowResultUseCase

interface LoginUseCase:
    FlowResultUseCase<LoginParam, Unit>