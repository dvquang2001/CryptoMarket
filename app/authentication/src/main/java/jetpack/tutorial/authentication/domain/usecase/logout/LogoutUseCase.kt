package jetpack.tutorial.authentication.domain.usecase.logout

import jetpack.tutorial.libcore.networking.utils.FlowResultUseCase

interface LogoutUseCase : FlowResultUseCase<Any, Unit>