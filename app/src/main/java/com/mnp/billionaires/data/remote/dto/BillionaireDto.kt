package com.mnp.billionaires.data.remote.dto

import com.mnp.billionaires.domain.model.Billionaire

data class BillionaireDto(
    val age: Int,
    val country_territory: String,
    val id: Int,
    val industry: String,
    val name: String,
    val networth: String,
    val rank: Int,
    val source: String
)

fun BillionaireDto.toBillionaire(): Billionaire{
    return Billionaire(
        age = age,
        country_territory = country_territory,
        id = id,
        industry = industry,
        name = name,
        networth = networth,
        rank = rank,
        source = source
    )
}