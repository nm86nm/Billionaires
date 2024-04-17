package com.mnp.billionaires.presentation.billionaire_description

import com.mnp.billionaires.domain.model.Billionaire
import com.mnp.billionaires.domain.model.BillionaireDescription

data class BillionaireDescriptionState(
    val error: String = "",
    val billionaire: List<Billionaire> = emptyList() ,
    val billionaireDescription: BillionaireDescription? = null,
    val isLoading: Boolean = false
)
