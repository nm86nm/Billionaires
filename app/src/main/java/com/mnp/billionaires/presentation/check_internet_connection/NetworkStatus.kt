package com.mnp.billionaires.presentation.check_internet_connection

import kotlinx.coroutines.flow.Flow

interface NetworkStatus {

    fun observe(): Flow<Status>

    enum class Status {
        Available, Unavailable, Losing, Lost
    }
}