package jetpack.tutorial.libcore.networking.utils

import java.net.HttpURLConnection.HTTP_BAD_REQUEST
import kotlin.reflect.KClass

suspend inline fun <DTO, DM, ERROR: Any> safeCallApi(
    crossinline apiCall: suspend () -> DTO,
    transformer: (DTO) -> DM,
    selfHandleStatusCode: List<Int> = listOf(HTTP_BAD_REQUEST),
    errorCLass: KClass<ERROR>,
    errorMapper: (ERROR) -> Failure,
    noinline onCallDone: suspend (DTO) -> Unit = {}
) {
    //todo: for api caller
}