package repleyva.dev.cryptocurrency.data.repository

import repleyva.dev.cryptocurrency.data.remote.CoinPaprikaApi
import repleyva.dev.cryptocurrency.data.remote.dto.CoinDetailDto
import repleyva.dev.cryptocurrency.data.remote.dto.CoinDto
import repleyva.dev.cryptocurrency.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> = api.getCoins()

    override suspend fun getCoinById(coinId: String): CoinDetailDto = api.getCoinById(coinId)
}