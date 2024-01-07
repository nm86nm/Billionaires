package com.mnp.billionaires.data.repository

import com.mnp.billionaires.data.remote.BillionaireApi
import com.mnp.billionaires.data.remote.dto.BillionaireDto
import com.mnp.billionaires.domain.repository.BillionaireRepository
import javax.inject.Inject

class BillionaireRepositoryImpl @Inject constructor(
    private val api: BillionaireApi
): BillionaireRepository {
    override suspend fun getBillionaires(): List<BillionaireDto> {
        return api.getBillionaires()
    }
}