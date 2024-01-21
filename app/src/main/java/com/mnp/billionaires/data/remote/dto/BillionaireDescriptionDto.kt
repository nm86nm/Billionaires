package com.mnp.billionaires.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.mnp.billionaires.domain.model.BillionaireDescription

data class BillionaireDescriptionDto(
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: String
)

fun BillionaireDescriptionDto.toBillionaireDescription(): BillionaireDescription{
    return BillionaireDescription(
        description = description,
        id = id
    )
}