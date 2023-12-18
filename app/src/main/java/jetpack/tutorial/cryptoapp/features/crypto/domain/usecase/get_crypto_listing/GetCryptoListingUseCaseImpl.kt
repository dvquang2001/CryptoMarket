package jetpack.tutorial.cryptoapp.features.crypto.domain.usecase.get_crypto_listing

import jetpack.tutorial.cryptoapp.core.networking.utils.ResultModel
import jetpack.tutorial.cryptoapp.features.crypto.domain.model.CryptoListingModel
import jetpack.tutorial.cryptoapp.features.crypto.domain.repository.CryptoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCryptoListingUseCaseImpl @Inject constructor(
    private val cryptoRepository: CryptoRepository
) : GetCryptoListingUseCase {
    override fun execute(param: CryptoListingParam): Flow<ResultModel<List<CryptoListingModel>>> {
        return cryptoRepository.getCryptoListings(
            param.fetchFromRemote,
            param.query
        )
    }
}