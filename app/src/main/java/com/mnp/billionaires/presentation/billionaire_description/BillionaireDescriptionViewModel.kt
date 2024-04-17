package com.mnp.billionaires.presentation.billionaire_description

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mnp.billionaires.common.Resource
import com.mnp.billionaires.domain.use_case.get_billionaire.GetBillionaireUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BillionaireDescriptionViewModel @Inject constructor(
    private val getBillionaireUseCase: GetBillionaireUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {
    private val _state = mutableStateOf(BillionaireDescriptionState())
    val state: State<BillionaireDescriptionState> = _state

    init {
        savedStateHandle.get<String>("name")?.let { name ->
            getBillionaire(name)
        }
    }
    private fun getBillionaire(name: String){
        getBillionaireUseCase(name).onEach { result ->
            when(result){
                is Resource.Loading -> {
                    _state.value = BillionaireDescriptionState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = BillionaireDescriptionState(billionaireDescription = result.data)
                }
                is Resource.Error -> {
                    _state.value = BillionaireDescriptionState(error = result.message ?: "Something wrong!")
                }
            }
        }.launchIn(viewModelScope)
    }
}