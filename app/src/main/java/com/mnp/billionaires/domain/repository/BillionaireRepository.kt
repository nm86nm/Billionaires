package com.mnp.billionaires.domain.repository

import com.mnp.billionaires.data.remote.dto.BillionaireDescriptionDto
import com.mnp.billionaires.data.remote.dto.BillionaireDto
import com.mnp.billionaires.domain.model.BillionaireDescription

interface BillionaireRepository {
    suspend fun getBillionaires(): List<BillionaireDto>
    suspend fun getBillionaireById(name: String): BillionaireDescriptionDto
}