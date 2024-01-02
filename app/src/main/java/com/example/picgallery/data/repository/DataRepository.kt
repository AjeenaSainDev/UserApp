package com.example.picgallery.data.repository

import com.example.picgallery.data.remote.RemoteSource
import com.example.picgallery.domain.model.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DataRepository @Inject
constructor(private  val remoteSource: RemoteSource): DataSource {
    override suspend fun getUsers():List<User> ?{
        return remoteSource.getUsers().data
    }
}
