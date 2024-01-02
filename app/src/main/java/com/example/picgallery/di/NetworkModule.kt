package com.example.picgallery.di

import com.example.picgallery.BuildConfig
import com.example.picgallery.data.remote.RemoteSource
import com.example.picgallery.data.remote.RemoteSourceImpl
import com.example.picgallery.data.remote.services.ApiServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient,url: String): Retrofit{
        return  Retrofit.Builder()
            .baseUrl(url)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
    @Provides
    @Singleton
    fun createClient(): OkHttpClient {
        val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val loggingInterceptor =
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
            okHttpClientBuilder.addInterceptor(loggingInterceptor)
        }
        return okHttpClientBuilder.build()
    }
   @Singleton
   @Provides
   fun provideApiService(retrofit: Retrofit): ApiServices{
       return  retrofit.create(ApiServices::class.java)
   }
   @Provides
   @Singleton
   fun provideRemoteRepository(apiServices: ApiServices): RemoteSource{
       return RemoteSourceImpl(apiServices)
   }

}