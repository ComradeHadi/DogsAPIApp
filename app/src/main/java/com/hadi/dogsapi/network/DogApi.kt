package com.hadi.dogsapi.network

import com.hadi.dogsapi.ApiUtils
import com.hadi.dogsapi.data.ServerDataClasses
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author comrade hadi
 */
interface DogApi {

    @GET(value = "${ApiUtils.SINGLE_BREED}/{breed}/${ApiUtils.IMAGES}")
    fun getBreedImages(@Path("breed") breed: String): Deferred<Response<ServerDataClasses.DogApiImageResponse>>

    @GET(value = "${ApiUtils.SINGLE_BREED}/{breed}/{sbreed}/${ApiUtils.IMAGES}")
    fun getSubBreedImages(@Path("breed") breed: String, @Path("sbreed") sBreed: String): Deferred<Response<ServerDataClasses.DogApiImageResponse>>

    @GET(value = ApiUtils.ALL_BREEDS)
    fun getAllDogBreeds(): Deferred<Response<ServerDataClasses.DogApiResponse>>
}