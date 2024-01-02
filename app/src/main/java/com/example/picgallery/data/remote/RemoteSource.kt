package com.example.picgallery.data.remote

import com.example.picgallery.data.AppResponse
import com.example.picgallery.domain.model.User
import com.example.picgallery.ui.navigation.Screen
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface RemoteSource {
    suspend fun  getUsers() : AppResponse<List<User>>
}