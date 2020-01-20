package com.hadi.dogsapi.viewModels

import android.content.Context
import com.google.gson.JsonArray
import com.hadi.dogsapi.network.DogApi
import com.hadi.dogsapi.network.DogRepositoryImpl
import javax.inject.Inject

/**
 * @author comrade hadi
 */
class SubBreedImageViewModel @Inject constructor(var dogRepositoryImpl: DogRepositoryImpl, context: Context): DetailViewModel(dogRepositoryImpl, context){

    lateinit var subBreed: String

    override suspend fun getImageResponse(): JsonArray? {
        val jsonArray = dogRepositoryImpl.getSubBreedImages(breed.name, subBreed)
        return jsonArray
    }
}