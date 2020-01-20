package com.hadi.dogsapi

import com.hadi.dogsapi.network.DogApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

/**
 * @author comrade hadi
 */
@Module
class RestApiModule {

    @Provides
    @Singleton
    fun provideDogApi(@Named("dogRetrofit")dogRetrofit: Retrofit): DogApi = dogRetrofit.create(DogApi::class.java)
}