package com.mnp.billionaires.data.repository

import com.mnp.billionaires.data.remote.BillionaireApi
import com.mnp.billionaires.data.remote.dto.BillionaireDescriptionDto
import com.mnp.billionaires.data.remote.dto.BillionaireDto
import com.mnp.billionaires.data.remote.dto.ForbesResponseDto
import com.mnp.billionaires.domain.repository.BillionaireRepository
import javax.inject.Inject

class BillionaireRepositoryImpl @Inject constructor(
    private val api: BillionaireApi
): BillionaireRepository {
    override suspend fun getBillionaires(): List<BillionaireDto> {
        return api.getBillionaires()
    }

    override suspend fun getBillionaireById(name: String): BillionaireDescriptionDto {
        return api.getBillionaireById(name)
    }

    override suspend fun getForbesBillionaires(): ForbesResponseDto {
        return api.getForbesBillionaires("https://www.forbes.com/forbesapi/person/rtb/0/position/true.json?fields=rank,personName,finalWorth,source,countryOfCitizenship,industries,age,uri&limit=200")
    }
}