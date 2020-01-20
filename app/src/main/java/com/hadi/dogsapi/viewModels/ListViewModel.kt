package com.hadi.dogsapi.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.hadi.dogsapi.data.DataClasses
import com.hadi.dogsapi.network.DogApi
import com.hadi.dogsapi.network.DogRepository
import com.hadi.dogsapi.network.DogRepositoryImpl
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author comrade hadi
 */
class ListViewModel @Inject constructor(private val dogRepository: DogRepositoryImpl): ViewModel() {

    private val breedList = mutableListOf<DataClasses.Breed>()

    val dataStateLiveData: MutableLiveData<DataClasses.DataState> by lazy {
        MutableLiveData<DataClasses.DataState>()
    }

    private val breedsLiveData: MutableLiveData<List<DataClasses.Breed>> by lazy {
        MutableLiveData<List<DataClasses.Breed>>().also {
            loadBreeds()
        }
    }

    fun getBreedsLiveData(): LiveData<List<DataClasses.Breed>> {
        return breedsLiveData
    }

    fun getDataStateLiveData(): LiveData<DataClasses.DataState> {
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
                breedList.add(DataClasses.Breed(breedName, subBreedList))
            }

            dataStateLiveData.value = DataClasses.DataState(breedList.isEmpty())
            breedsLiveData.postValue(breedList)
        }
    }
}