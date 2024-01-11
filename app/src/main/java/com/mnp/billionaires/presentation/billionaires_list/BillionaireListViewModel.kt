package com.mnp.billionaires.presentation.billionaires_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mnp.billionaires.common.Resource
import com.mnp.billionaires.domain.use_case.get_bilionaires.GetBillionairesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BillionaireListViewModel @Inject constructor(
    private val getBillionairesUseCase: GetBillionairesUseCase
): ViewModel() {
    private val _state = mutableStateOf(BillionaireListState())
    val state: State<BillionaireListState> = _state

    init {
        getBillionaires()
    }
    private fun getBillionaires(){
        getBillionairesUseCase().onEach { result ->
            when(result){
                is Resource.Loading -> {
                    _state.value = BillionaireListState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = BillionaireListState(billionaires = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = BillionaireListState(error = result.message ?: "Something wrong!")
                }
            }
        }.launchIn(viewModelScope)
    }
}