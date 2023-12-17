package jetpack.tutorial.cryptoapp.features.crypto.data.remote

import jetpack.tutorial.cryptoapp.features.crypto.data.remote.dto.CryptoInfoDto
import jetpack.tutorial.cryptoapp.features.crypto.data.remote.dto.CryptoListingDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CryptoApi {

    @GET("markets?vs_currency=usd&order=market_cap_desc&per_page=100&page=1&sparkline=false&locale=en")
    suspend fun getListCoins(): List<CryptoListingDto>

    @GET("{id}")
    suspend fun getCoinInfoById(
        @Path("id") id: String
    ): CryptoInfoDto

    companion object {
        const val BASE_URL = "https://api.coingecko.com/api/v3/coins/"
    }
}