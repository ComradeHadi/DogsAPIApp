package com.hadi.dogsapi.viewModels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.hadi.dogsapi.R
import com.hadi.dogsapi.data.ServerDataClasses
import com.hadi.dogsapi.network.DogRepositoryImpl
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author comrade hadi
 */
open class DetailViewModel @Inject constructor(private val dogRepository: DogRepositoryImpl,
                                               private val context: Context): ViewModel() {


    var urlList = mutableListOf<String>()

    lateinit var breed: ServerDataClasses.Breed

    private val urlLiveData: MutableLiveData<List<String>> by lazy {
        MutableLiveData<List<String>>().also {
            loadImageUrls()
        }
    }

    open fun getImageUrlLiveData(): LiveData<List<String>> {
        return urlLiveData
    }

    fun subBreedListTitle(): String {
        if (breed.subBreeds.isEmpty()){
            return context.getString(R.string.noSubBreedText, breed.name)
        }
        return context.getString(R.string.subBreedText, breed.name)
    }

    fun loadImageUrls(){
        viewModelScope.launch {
            val jsonArray = getImageResponse()
            postUrls(jsonArray)
        }
    }

    open suspend fun getImageResponse(): JsonArray? {
        val jsonArray = dogRepository.getBreedImages(breed.name)
        return jsonArray
    }

    private fun postUrls(jsonArray: JsonArray?) {
        val gson = Gson()
        val imageList = gson.fromJson(jsonArray, Array<String>::class.java).toList()
        urlList.addAll(imageList)
        urlLiveData.postValue(urlList)
    }
}