package com.mnp.billionaires.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.mnp.billionaires.domain.model.Billionaire

data class BillionaireDto(
    val age: String,
    @SerializedName("country/territory")
    val countryterritory: String,
    val id: String,
    val industry: String,
    val name: String,
    val networth: String,
    val rank: String,
    val source: String
)

fun BillionaireDto.toBillionaire(): Billionaire{
    return Billionaire(
        age = age,
        countryterritory = countryterritory,
        id = id,
        industry = industry,
        name = name,
        networth = networth,
        rank = rank,
        source = source
    )
}