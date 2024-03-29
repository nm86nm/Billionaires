package com.mnp.billionaires.common

sealed class Resource<T>(val data: T? = null,val message: String? = null) {
    class Error<T>(message: String? = null, data: T? = null): Resource<T>(data, message)
    class Loading<T>(data: T? = null): Resource<T>(data)
    class Success<T>(data: T): Resource<T>(data)
}