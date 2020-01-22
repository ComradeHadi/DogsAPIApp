package com.hadi.dogsapi.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.hadi.dogsapi.data.ServerDataClasses
import com.hadi.dogsapi.network.DogRepositoryImpl
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author comrade hadi
 */
class ListViewModel @Inject constructor(private val dogRepository: DogRepositoryImpl): ViewModel() {

    private val breedList = mutableListOf<ServerDataClasses.Breed>()

    val dataStateLiveData: MutableLiveData<ServerDataClasses.DataState> by lazy {
        MutableLiveData<ServerDataClasses.DataState>()
    }

    private val breedsLiveData: MutableLiveData<List<ServerDataClasses.Breed>> by lazy {
        MutableLiveData<List<ServerDataClasses.Breed>>().also {
            loadBreeds()
        }
    }

    fun getBreedsLiveData(): LiveData<List<ServerDataClasses.Breed>> {
        return breedsLiveData
    }

    fun getDataStateLiveData(): LiveData<ServerDataClasses.DataState> {
        return dataStateLiveData
    }

    private fun loadBreeds() {
        viewModelScope.launch {
            val breeds = dogRepository.getDogList()
            breeds?.entrySet()?.map {
                val breedName = it.key
                val subBreedArray = it.value.asJsonArray
                val gson = Gson()
                val subBreedList = gson.fromJson(subBreedArray, Array<String>::class.java).toList()
                breedList.add(ServerDataClasses.Breed(breedName, subBreedList))
            }

            dataStateLiveData.value = ServerDataClasses.DataState(breedList.isEmpty())
            breedsLiveData.postValue(breedList)
        }
    }
}