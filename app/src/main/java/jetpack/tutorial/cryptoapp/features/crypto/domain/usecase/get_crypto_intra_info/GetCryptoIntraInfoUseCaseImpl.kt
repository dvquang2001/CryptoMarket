package jetpack.tutorial.cryptoapp.features.crypto.domain.usecase.get_crypto_intra_info

import jetpack.tutorial.cryptoapp.core.networking.utils.ResultModel
import jetpack.tutorial.cryptoapp.features.crypto.domain.model.CryptoIntraInfoModel
import jetpack.tutorial.cryptoapp.features.crypto.domain.repository.CryptoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCryptoIntraInfoUseCaseImpl @Inject constructor(
    private val cryptoRepository: CryptoRepository
) : GetCryptoIntraInfoUseCase{
    override fun execute(param: CryptoIntraInfoParam): Flow<ResultModel<CryptoIntraInfoModel>> {
        return cryptoRepository.getCoinPricesById(param.id)
    }
}