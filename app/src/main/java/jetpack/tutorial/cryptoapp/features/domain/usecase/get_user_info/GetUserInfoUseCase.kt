package jetpack.tutorial.cryptoapp.features.domain.usecase.get_user_info

import jetpack.tutorial.cryptoapp.core.networking.utils.FlowResultUseCase
import jetpack.tutorial.cryptoapp.features.domain.model.UserDataModel

interface GetUserInfoUseCase : FlowResultUseCase<Any, UserDataModel>