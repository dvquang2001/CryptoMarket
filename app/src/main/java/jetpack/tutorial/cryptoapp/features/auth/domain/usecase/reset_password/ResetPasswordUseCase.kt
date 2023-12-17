package jetpack.tutorial.cryptoapp.features.auth.domain.usecase.reset_password

import jetpack.tutorial.cryptoapp.core.networking.utils.FlowResultUseCase

interface ResetPasswordUseCase : FlowResultUseCase<ResetPasswordParam, Unit>