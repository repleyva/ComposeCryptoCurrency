package repleyva.dev.cryptocurrency.domain.use_case.get_coint

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import repleyva.dev.cryptocurrency.common.DataState
import repleyva.dev.cryptocurrency.data.remote.dto.toCoin
import repleyva.dev.cryptocurrency.data.remote.dto.toCoinDetail
import repleyva.dev.cryptocurrency.domain.model.Coin
import repleyva.dev.cryptocurrency.domain.model.CoinDetail
import repleyva.dev.cryptocurrency.domain.repository.CoinRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCointUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<DataState<CoinDetail>> = flow {
        try {
            emit(DataState.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(DataState.Success(coin))
        } catch (e: HttpException) {
            emit(DataState.Error(e.localizedMessage ?: "An unexpected error ocurred :("))
        } catch (e: IOException) {
            emit(DataState.Error("Couldn´t reach server. Check your internet connection :/"))
        }
    }
}