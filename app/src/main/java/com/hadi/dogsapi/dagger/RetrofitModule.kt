package com.hadi.dogsapi

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.hadi.dogsapi.ApiUtils
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

/**
 * @author comrade hadi
 */
@Module
class RetrofitModule {

    @Singleton
    @Provides
    @Named(value = "dogRetrofit")
    fun providesDogClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiUtils.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }
}