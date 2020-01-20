package com.hadi.dogsapi.viewModels

import androidx.lifecycle.ViewModel

/**
 * @author comrade hadi
 */
open class BaseBreedViewModel<T>(item: T) : ViewModel() {
    open var name = item.toString()
}