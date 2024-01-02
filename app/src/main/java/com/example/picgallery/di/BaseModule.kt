package com.example.picgallery.di

import com.example.picgallery.data.repository.DataRepository
import com.example.picgallery.data.repository.DataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class BaseModule {
    @Binds
    @Singleton
    abstract fun bindrespository(dataRepository: DataRepository): DataSource
}