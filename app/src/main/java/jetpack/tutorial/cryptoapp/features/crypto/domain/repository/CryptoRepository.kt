package jetpack.tutorial.cryptoapp.features.crypto.domain.repository

import jetpack.tutorial.cryptoapp.core.networking.utils.ResultModel
import jetpack.tutorial.cryptoapp.features.crypto.domain.model.CryptoInfo
import jetpack.tutorial.cryptoapp.features.crypto.domain.model.CryptoListing
import kotlinx.coroutines.flow.Flow

interface CryptoRepository {

    suspend fun getCryptoListings(
        fetchFromRemote: Boolean
    ): Flow<ResultModel<List<CryptoListing>>>

    suspend fun getCryptoInfoById(
        id: String
    ): Flow<ResultModel<CryptoInfo>>
}