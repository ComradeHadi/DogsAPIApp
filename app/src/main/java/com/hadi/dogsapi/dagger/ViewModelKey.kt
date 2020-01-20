package com.hadi.dogsapi

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * @author comrade hadi
 */
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)