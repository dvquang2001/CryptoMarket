package jetpack.tutorial.cryptoapp.features.crypto.data.repository

import jetpack.tutorial.cryptoapp.core.networking.utils.ResultModel
import jetpack.tutorial.cryptoapp.features.crypto.data.local.CryptoDatabase
import jetpack.tutorial.cryptoapp.features.crypto.data.remote.CryptoApi
import jetpack.tutorial.cryptoapp.features.crypto.domain.model.CryptoInfo
import jetpack.tutorial.cryptoapp.features.crypto.domain.model.CryptoListing
import jetpack.tutorial.cryptoapp.features.crypto.domain.repository.CryptoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CryptoRepositoryImpl @Inject constructor(
    private val api: CryptoApi,
    private val db: CryptoDatabase
) : CryptoRepository{

    private val dao = db.dao

    override suspend fun getCryptoListings(fetchFromRemote: Boolean): Flow<ResultModel<List<CryptoListing>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getCryptoInfoById(id: String): Flow<ResultModel<CryptoInfo>> {
        return flow {
            try {
                val cryptoInfoDto = api.getCoinInfoById(id)
            } catch (t: Throwable) {
                t.printStackTrace()
                emit(ResultModel.Error(t))
            }
        }
    }
}