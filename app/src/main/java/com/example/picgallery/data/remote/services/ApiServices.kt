package com.example.picgallery.data.remote.services

import com.example.picgallery.data.AppResponse
import com.example.picgallery.domain.model.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiServices {
    @GET("/users")
    suspend fun  fetchUsers() : Response<List<User>>

}