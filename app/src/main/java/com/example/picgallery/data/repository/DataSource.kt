package com.example.picgallery.data.repository

import com.example.picgallery.domain.model.User
import kotlinx.coroutines.flow.Flow


interface DataSource {
   suspend fun getUsers(): List<User>?
}