package jetpack.tutorial.crypto.domain.usecase.get_crypto_info

import jetpack.tutorial.crypto.domain.model.CryptoInfoModel
import jetpack.tutorial.crypto.domain.repository.CryptoRepository
import jetpack.tutorial.libcore.networking.utils.ResultModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCryptoInfoUseCaseImpl @Inject constructor(
    private val cryptoRepository: CryptoRepository
) : GetCryptoInfoUseCase{
    override fun execute(param: CryptoInfoParam): Flow<ResultModel<CryptoInfoModel>> {
        return cryptoRepository.getCryptoInfoById(param.id)
    }
}