package com.hadi.dogsapi.viewModels

import com.hadi.dogsapi.data.ServerDataClasses

/**
 * @author comrade hadi
 */
class MainBreedViewModel(breed: ServerDataClasses.Breed) : BaseBreedViewModel<ServerDataClasses.Breed>(breed) {
    override var name = breed.name
}