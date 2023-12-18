package jetpack.tutorial.cryptoapp.features.crypto.domain.repository

import jetpack.tutorial.cryptoapp.core.networking.utils.ResultModel
import jetpack.tutorial.cryptoapp.features.crypto.domain.model.CryptoInfoModel
import jetpack.tutorial.cryptoapp.features.crypto.domain.model.CryptoIntraInfoModel
import jetpack.tutorial.cryptoapp.features.crypto.domain.model.CryptoListingModel
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