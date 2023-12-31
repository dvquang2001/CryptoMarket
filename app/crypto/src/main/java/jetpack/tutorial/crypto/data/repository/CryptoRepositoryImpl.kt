package jetpack.tutorial.crypto.data.repository

import jetpack.tutorial.crypto.data.local.CryptoDatabase
import jetpack.tutorial.crypto.data.mapper.toCryptoInfo
import jetpack.tutorial.crypto.data.mapper.toCryptoIntraInfoModel
import jetpack.tutorial.crypto.data.mapper.toCryptoListing
import jetpack.tutorial.crypto.data.mapper.toCryptoListingEntity
import jetpack.tutorial.crypto.data.remote.CryptoApi
import jetpack.tutorial.crypto.domain.model.CryptoInfoModel
import jetpack.tutorial.crypto.domain.model.CryptoIntraInfoModel
import jetpack.tutorial.crypto.domain.model.CryptoListingModel
import jetpack.tutorial.crypto.domain.repository.CryptoRepository
import jetpack.tutorial.libcore.networking.utils.ResultModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CryptoRepositoryImpl @Inject constructor(
    private val api: CryptoApi,
    private val db: CryptoDatabase
) : CryptoRepository {

    private val dao = db.dao

    override fun getCryptoListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<ResultModel<List<CryptoListingModel>>> {
        return flow {
            val localListings = dao.searchCryptoListings(query)   // get cache data
            emit(
                ResultModel.Success(
                localListings.map { it.toCryptoListing() }
            ))



            val isDbEmpty = localListings.isEmpty() && query.isBlank() // make sure db has no data
            val shouldJustLoadDataFromCache = !isDbEmpty && !fetchFromRemote
            if(shouldJustLoadDataFromCache) {
                return@flow
            }
            val remoteListings = try {
                val response = api.getListCoins()
                response.map { it.toCryptoListing() }
            } catch (t: Throwable) {
                t.printStackTrace()
                emit(ResultModel.Error(t))
                null
            }

            remoteListings?.let { listings ->
                dao.clearCryptoListings()
                dao.insertCryptoListing(
                    listings.map { it.toCryptoListingEntity() }
                )
                emit(
                    ResultModel.Success(
                    dao
                        .searchCryptoListings("")
                        .map { it.toCryptoListing() }
                ))
            }
        }
    }

    override fun getCryptoInfoById(id: String): Flow<ResultModel<CryptoInfoModel>> {
        return flow {
            val result = try {
                val cryptoInfoDto = api.getCoinInfoById(id)
                val result = cryptoInfoDto.toCryptoInfo(id)
                ResultModel.Success(result)
            } catch (t: Throwable) {
                t.printStackTrace()
                ResultModel.Error(t)
            }
            emit(result)
        }
    }

    override fun getCoinPricesById(id: String): Flow<ResultModel<CryptoIntraInfoModel>> {
        return flow {
            val result = try {
                val cryptoIntraInfoDto = api.getCoinPricesById(id)
                val result = cryptoIntraInfoDto.toCryptoIntraInfoModel()
                ResultModel.Success(result)
            } catch (t: Throwable) {
                t.printStackTrace()
                ResultModel.Error(t)
            }
            emit(result)
        }
    }
}