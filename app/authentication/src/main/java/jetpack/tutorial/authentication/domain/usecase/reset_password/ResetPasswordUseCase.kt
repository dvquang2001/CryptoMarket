package jetpack.tutorial.authentication.domain.usecase.reset_password

import jetpack.tutorial.libcore.networking.utils.FlowResultUseCase

interface ResetPasswordUseCase : FlowResultUseCase<ResetPasswordParam, Unit>