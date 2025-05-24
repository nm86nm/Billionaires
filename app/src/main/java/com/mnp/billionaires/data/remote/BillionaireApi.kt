package com.mnp.billionaires.data.remote

import com.mnp.billionaires.data.remote.dto.BillionaireDescriptionDto
import com.mnp.billionaires.data.remote.dto.BillionaireDto
import retrofit2.http.GET
import retrofit2.http.Path

interface BillionaireApi {

    @GET("billionaire_copy2.json")
    suspend fun getBillionaires(): List<BillionaireDto>

    @GET("description/{name}.json")
    suspend fun getBillionaireById(@Path("name") billionaireId: String): BillionaireDescriptionDto
}