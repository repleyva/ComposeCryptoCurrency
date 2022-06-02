package repleyva.dev.cryptocurrency.domain.use_case.get_coints

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import repleyva.dev.cryptocurrency.common.DataState
import repleyva.dev.cryptocurrency.data.remote.dto.toCoin
import repleyva.dev.cryptocurrency.domain.model.Coin
import repleyva.dev.cryptocurrency.domain.repository.CoinRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCointsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<DataState<List<Coin>>> = flow {
        try {
            emit(DataState.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(DataState.Success(coins))
        } catch (e: HttpException) {
            emit(DataState.Error(e.localizedMessage ?: "An unexpected error ocurred :("))
        } catch (e: IOException) {
            emit(DataState.Error("Couldn´t reach server. Check your internet connection :/"))
        }
    }
}