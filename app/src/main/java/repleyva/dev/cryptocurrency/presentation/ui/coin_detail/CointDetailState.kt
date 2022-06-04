package repleyva.dev.cryptocurrency.presentation.ui.coin_detail

import repleyva.dev.cryptocurrency.common.Constants.EMPTY_STRING
import repleyva.dev.cryptocurrency.domain.model.Coin
import repleyva.dev.cryptocurrency.domain.model.CoinDetail

data class CointDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = EMPTY_STRING
)