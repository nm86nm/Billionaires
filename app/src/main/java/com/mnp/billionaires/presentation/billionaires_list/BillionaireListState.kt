package com.mnp.billionaires.presentation.billionaires_list

import com.mnp.billionaires.domain.model.Billionaire

data class BillionaireListState(
    val error: String = "",
    val billionaires: List<Billionaire> = emptyList(),
    val isLoading: Boolean = false
)
