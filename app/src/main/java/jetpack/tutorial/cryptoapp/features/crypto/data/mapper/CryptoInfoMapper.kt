package jetpack.tutorial.cryptoapp.features.crypto.data.mapper

import jetpack.tutorial.cryptoapp.features.crypto.data.remote.dto.CryptoInfoDto
import jetpack.tutorial.cryptoapp.features.crypto.data.remote.dto.market_data.MarketData
import jetpack.tutorial.cryptoapp.features.crypto.domain.model.CryptoInfoModel

fun CryptoInfoDto.toCryptoInfo(currencyId: String): CryptoInfoModel {
    val totalVolume = getToTalVolumeValue(currencyId, marketData)
    return CryptoInfoModel(
        id,
        symbol,
        name,
        image.thumb,
        image.small,
        image.large,
        currentPrice,
        totalVolume,
    )
}

private fun getToTalVolumeValue(currencyId: String, marketData: MarketData?): Long {
    var totalVolume = 0L
    marketData?.let {
        totalVolume = when (currencyId) {
            "aed" -> marketData.total_volume.aed
            "ars" -> marketData.total_volume.ars
            "aud" -> marketData.total_volume.aud
            "bch" -> marketData.total_volume.bch
            "bdt" -> marketData.total_volume.bdt
            "bhd" -> marketData.total_volume.bhd
            "bits" -> marketData.total_volume.bits
            "bmd" -> marketData.total_volume.bmd
            "bnb" -> marketData.total_volume.bnb
            "brl" -> marketData.total_volume.brl
            "btc" -> marketData.total_volume.btc
            "cad" -> marketData.total_volume.cad
            "chf" -> marketData.total_volume.chf
            "clp" -> marketData.total_volume.clp
            "cny" -> marketData.total_volume.cny
            "czk" -> marketData.total_volume.czk
            "dkk" -> marketData.total_volume.dkk
            "dot" -> marketData.total_volume.dot
            "eos" -> marketData.total_volume.eos
            "eth" -> marketData.total_volume.eth
            "eur" -> marketData.total_volume.eur
            "gbp" -> marketData.total_volume.gbp
            "gel" -> marketData.total_volume.gel
            "hkd" -> marketData.total_volume.hkd
            "huf" -> marketData.total_volume.huf
            "idr" -> marketData.total_volume.idr
            "ils" -> marketData.total_volume.ils
            "inr" -> marketData.total_volume.inr
            "jpy" -> marketData.total_volume.jpy
            "krw" -> marketData.total_volume.krw
            "kwd" -> marketData.total_volume.kwd
            "link" -> marketData.total_volume.link
            "lkr" -> marketData.total_volume.lkr
            "ltc" -> marketData.total_volume.ltc
            "mmk" -> marketData.total_volume.mmk
            "mxn" -> marketData.total_volume.mxn
            "myr" -> marketData.total_volume.myr
            "ngn" -> marketData.total_volume.ngn
            "nok" -> marketData.total_volume.nok
            "nzd" -> marketData.total_volume.nzd
            "php" -> marketData.total_volume.php
            "pkr" -> marketData.total_volume.pkr
            "pln" -> marketData.total_volume.pln
            "rub" -> marketData.total_volume.rub
            "sar" -> marketData.total_volume.sar
            "sats" -> marketData.total_volume.sats
            "sek" -> marketData.total_volume.sek
            "sgd" -> marketData.total_volume.sgd
            "thb" -> marketData.total_volume.thb
            "try" -> marketData.total_volume.`try`
            "twd" -> marketData.total_volume.twd
            "uah" -> marketData.total_volume.uah
            "usd" -> marketData.total_volume.usd
            "vef" -> marketData.total_volume.vef
            "vnd" -> marketData.total_volume.vnd
            "xag" -> marketData.total_volume.xag
            "xau" -> marketData.total_volume.xau
            "xdr" -> marketData.total_volume.xdr
            "xlm" -> marketData.total_volume.xlm
            "xrp" -> marketData.total_volume.xrp
            "yfi" -> marketData.total_volume.yfi
            "zar" -> marketData.total_volume.zar
            else -> marketData.total_volume.usd// Default value or handle error case
        }
    }
    return totalVolume
}