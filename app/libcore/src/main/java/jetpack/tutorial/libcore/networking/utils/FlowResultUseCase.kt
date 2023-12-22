package jetpack.tutorial.libcore.networking.utils

import kotlinx.coroutines.flow.Flow

interface FlowResultUseCase<in T, out U> {
    fun execute(param: T): Flow<ResultModel<U>>
}