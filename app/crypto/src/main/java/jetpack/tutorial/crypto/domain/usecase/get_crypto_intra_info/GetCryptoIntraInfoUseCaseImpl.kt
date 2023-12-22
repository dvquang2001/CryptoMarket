package jetpack.tutorial.crypto.domain.usecase.get_crypto_intra_info

import jetpack.tutorial.crypto.domain.model.CryptoIntraInfoModel
import jetpack.tutorial.crypto.domain.repository.CryptoRepository
import jetpack.tutorial.libcore.networking.utils.ResultModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCryptoIntraInfoUseCaseImpl @Inject constructor(
    private val cryptoRepository: CryptoRepository
) : GetCryptoIntraInfoUseCase{
    override fun execute(param: CryptoIntraInfoParam): Flow<ResultModel<CryptoIntraInfoModel>> {
        return cryptoRepository.getCoinPricesById(param.id)
    }
}