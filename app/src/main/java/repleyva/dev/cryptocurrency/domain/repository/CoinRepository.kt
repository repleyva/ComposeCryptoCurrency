package repleyva.dev.cryptocurrency.domain.repository

import repleyva.dev.cryptocurrency.data.remote.dto.CoinDetailDto
import repleyva.dev.cryptocurrency.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): List<CoinDetailDto>

}