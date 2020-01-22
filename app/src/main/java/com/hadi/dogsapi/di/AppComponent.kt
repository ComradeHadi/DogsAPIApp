package com.hadi.dogsapi.di

import com.hadi.dogsapi.DogApplication
import com.hadi.dogsapi.ui.BaseFragment
import com.hadi.dogsapi.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * @author comrade hadi
 */
@Singleton
@Component(modules = [AppModule::class, RetrofitModule::class, RestApiModule::class, ViewModelModule::class])
interface AppComponent {

    fun inject(application: DogApplication)
    fun inject(target: MainActivity)
    fun inject(target: BaseFragment)
}