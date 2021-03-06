package com.hadi.dogsapi

import android.app.Application
import com.hadi.dogsapi.di.AppComponent
import com.hadi.dogsapi.di.AppModule
import com.hadi.dogsapi.di.DaggerAppComponent


/**
 * @author comrade hadi
 */
class DogApplication: Application() {

    val appComponent: AppComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerAppComponent.builder().appModule(AppModule(this)).build()

    }
    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }

}