package com.mnp.billionaires.domain.repository

import com.mnp.billionaires.data.remote.dto.BillionaireDto

interface BillionaireRepository {
    suspend fun getBillionaires(): List<BillionaireDto>
}