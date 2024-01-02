package com.example.picgallery.data


sealed class AppResponse<T>(
    val data: T? = null,
    val errorCode: Int? = null
) {
    class Success<T>(data: T? = null) : AppResponse<T>(data)
    class Loading<T> : AppResponse<T>()
    class DataError<T>(data: T? = null, errorCode: Int) : AppResponse<T>(data, errorCode)
}