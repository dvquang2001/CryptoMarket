package jetpack.tutorial.crypto.domain.usecase.get_crypto_listing

import jetpack.tutorial.crypto.domain.model.CryptoListingModel
import jetpack.tutorial.crypto.domain.repository.CryptoRepository
import jetpack.tutorial.libcore.networking.utils.ResultModel
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