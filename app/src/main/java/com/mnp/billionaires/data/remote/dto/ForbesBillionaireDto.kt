package com.mnp.billionaires.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.mnp.billionaires.domain.model.Billionaire
import java.util.Locale

data class ForbesResponseDto(
    val personList: PersonListDto
)

data class PersonListDto(
    val personsLists: List<ForbesBillionaireDto>
)

data class ForbesBillionaireDto(
    val rank: Int,
    val personName: String,
    val finalWorth: Double,
    val source: String,
    val countryOfCitizenship: String,
    val industries: List<String>?,
    val age: Int?,
    val uri: String
)

fun ForbesBillionaireDto.toBillionaire(): Billionaire {
    return Billionaire(
        age = age?.toString() ?: "",
        countryterritory = countryOfCitizenship,
        id = uri,
        industry = industries?.firstOrNull() ?: "",
        name = personName,
        networth = "$" + String.format(Locale.US, "%.1f", finalWorth / 1000.0) + " B",
        rank = rank.toString(),
        source = source
    )
}
