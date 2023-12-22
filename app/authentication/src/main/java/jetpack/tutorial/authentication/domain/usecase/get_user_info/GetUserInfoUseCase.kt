package jetpack.tutorial.authentication.domain.usecase.get_user_info

import jetpack.tutorial.authentication.domain.model.UserDataModel
import jetpack.tutorial.libcore.networking.utils.FlowResultUseCase

interface GetUserInfoUseCase : FlowResultUseCase<Any, UserDataModel>