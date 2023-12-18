package jetpack.tutorial.cryptoapp.features.crypto.domain.usecase.get_crypto_info

import jetpack.tutorial.cryptoapp.core.networking.utils.ResultModel
import jetpack.tutorial.cryptoapp.features.crypto.domain.model.CryptoInfoModel
import jetpack.tutorial.cryptoapp.features.crypto.domain.repository.CryptoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCryptoInfoUseCaseImpl @Inject constructor(
    private val cryptoRepository: CryptoRepository
) : GetCryptoInfoUseCase{
    override fun execute(param: CryptoInfoParam): Flow<ResultModel<CryptoInfoModel>> {
        return cryptoRepository.getCryptoInfoById(param.id)
    }
}