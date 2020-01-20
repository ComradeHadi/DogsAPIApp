package com.hadi.dogsapi.network

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author comrade hadi
 */
@Singleton
class DogRepositoryImpl @Inject constructor(private val api: DogApi) : DogRepository, BaseRepository() {

    override suspend fun getDogList() : JsonObject? {
        val dogResponse = safeApiCall(
            call = {api.getAllDogBreeds().await()},
            errorMessage = "Error fetching dog breeds"
        )
        return dogResponse?.result
    }

    override suspend fun getBreedImages(breed: String): JsonArray? {
        val imageResponse = safeApiCall(
            call = {api.getBreedImages(breed).await()},
            errorMessage = "Error fetching breed images"
        )
        return imageResponse?.result
    }

    override suspend fun getSubBreedImages(breed: String, subBreed: String): JsonArray? {
        val imageResponse = safeApiCall(
            call = {api.getSubBreedImages(breed, subBreed).await()},
            errorMessage = "Error fetching sub breed images"
        )
        return imageResponse?.result
    }
}