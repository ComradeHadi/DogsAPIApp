package com.hadi.dogsapi.network

import androidx.lifecycle.LiveData
import com.hadi.dogsapi.ApiUtils
import com.hadi.dogsapi.data.DataClasses
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author comrade hadi
 */
interface DogApi {

    @GET(value = "${ApiUtils.SINGLE_BREED}/{breed}/${ApiUtils.IMAGES}")
    fun getBreedImages(@Path("breed") breed: String): Deferred<Response<DataClasses.DogApiImageResponse>>

    @GET(value = "${ApiUtils.SINGLE_BREED}/{breed}/{sbreed}/${ApiUtils.IMAGES}")
    fun getSubBreedImages(@Path("breed") breed: String, @Path("sbreed") sBreed: String): Deferred<Response<DataClasses.DogApiImageResponse>>

    @GET(value = ApiUtils.ALL_BREEDS)
    fun getAllDogBreeds(): Deferred<Response<DataClasses.DogApiResponse>>
}