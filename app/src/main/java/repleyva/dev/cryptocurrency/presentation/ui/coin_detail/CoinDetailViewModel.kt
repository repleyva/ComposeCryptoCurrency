package repleyva.dev.cryptocurrency.presentation.ui.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import repleyva.dev.cryptocurrency.common.Constants.PARAM_COIN_ID
import repleyva.dev.cryptocurrency.common.DataState
import repleyva.dev.cryptocurrency.domain.use_case.get_coint.GetCointUseCase
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCointUseCase: GetCointUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    /**
     * State
     */

    private val _state = mutableStateOf(CointDetailState())
    val state: State<CointDetailState> = _state

    /**
     * Init
     */

    init {
        savedStateHandle()
    }

    /**
     * Validations
     */

    private fun getCoin(coinId: String) {
        getCointUseCase(coinId).onEach { dataState ->
            when (dataState) {
                is DataState.Loading -> _state.value = CointDetailState(isLoading = true)
                is DataState.Success -> _state.value = CointDetailState(coin = dataState.data)
                is DataState.Error -> _state.value =
                    CointDetailState(error = dataState.message ?: "An unexpected error ocurred :(")
            }
        }.launchIn(viewModelScope)
    }

    private fun savedStateHandle() =
        savedStateHandle.get<String>(PARAM_COIN_ID)?.let { coinId ->
            getCoin(coinId)
        }
}