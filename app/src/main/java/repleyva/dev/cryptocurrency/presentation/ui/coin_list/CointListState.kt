package repleyva.dev.cryptocurrency.presentation.ui.coin_list

import repleyva.dev.cryptocurrency.common.Constants.EMPTY_STRING
import repleyva.dev.cryptocurrency.domain.model.Coin

data class CointListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = EMPTY_STRING
)