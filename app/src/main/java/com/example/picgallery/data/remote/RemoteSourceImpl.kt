package com.example.picgallery.data.remote

import android.util.Log
import com.example.picgallery.data.AppResponse
import com.example.picgallery.data.remote.services.ApiServices
import com.example.picgallery.domain.model.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RemoteSourceImpl @Inject
constructor(private val apiService: ApiServices ): RemoteSource{
    override suspend fun getUsers(): AppResponse<List<User> >{
        try {
            val userList = mutableListOf<User>()
            val userResponse = apiService.fetchUsers()
            if (userResponse.isSuccessful) {
                userResponse.body()?.let {
                    userList.addAll(it) // Assuming the API response is a List<User>
                }
                return AppResponse.Success(data = userList)
            } else {
                Log.e("API ERROR", "Response unsuccessful: ${userResponse.code()}")
                return AppResponse.DataError(errorCode = userResponse.code())
            }
        } catch (e: Exception) {
            Log.e("API ERROR", "Exception: ${e.message}", e)
            return AppResponse.DataError(errorCode = 400)
        }
    }

}