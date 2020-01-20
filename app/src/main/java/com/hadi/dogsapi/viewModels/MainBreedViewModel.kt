package com.hadi.dogsapi.viewModels

import com.hadi.dogsapi.data.DataClasses

/**
 * @author comrade hadi
 */
class MainBreedViewModel(breed: DataClasses.Breed) : BaseBreedViewModel<DataClasses.Breed>(breed) {
    override var name = breed.name
}