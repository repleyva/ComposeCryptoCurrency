package repleyva.dev.cryptocurrency.presentation.ui.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import repleyva.dev.cryptocurrency.common.DataState
import repleyva.dev.cryptocurrency.domain.use_case.get_coints.GetCointsUseCase
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCointsUseCase: GetCointsUseCase
) : ViewModel() {

    /**
     * State
     */

    private val _state = mutableStateOf(CointListState())
    val state: State<CointListState> = _state

    /**
     * Init
     */

    init {
        getCoins()
    }

    /**
     * Validations
     */

    private fun getCoins() {
        getCointsUseCase().onEach { dataState ->
            when (dataState) {
                is DataState.Loading -> _state.value = CointListState(isLoading = true)
                is DataState.Success -> _state.value =
                    CointListState(coins = dataState.data.orEmpty())
                is DataState.Error -> _state.value =
                    CointListState(error = dataState.message ?: "An unexpected error ocurred :(")
            }
        }.launchIn(viewModelScope)
    }
}