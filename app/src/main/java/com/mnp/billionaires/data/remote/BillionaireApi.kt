package com.mnp.billionaires.data.remote

import com.mnp.billionaires.data.remote.dto.BillionaireDto
import retrofit2.http.GET

interface BillionaireApi {

    @GET("billionaire.json")
    suspend fun getBillionaires(): List<BillionaireDto>
}