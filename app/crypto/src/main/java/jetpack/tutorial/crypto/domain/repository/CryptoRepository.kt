package jetpack.tutorial.crypto.domain.repository

import jetpack.tutorial.crypto.domain.model.CryptoInfoModel
import jetpack.tutorial.crypto.domain.model.CryptoIntraInfoModel
import jetpack.tutorial.crypto.domain.model.CryptoListingModel
import jetpack.tutorial.libcore.networking.utils.ResultModel
import kotlinx.coroutines.flow.Flow

interface CryptoRepository {

    fun getCryptoListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<ResultModel<List<CryptoListingModel>>>

    fun getCryptoInfoById(
        id: String
    ): Flow<ResultModel<CryptoInfoModel>>

    fun getCoinPricesById(
        id: String
    ): Flow<ResultModel<CryptoIntraInfoModel>>
}