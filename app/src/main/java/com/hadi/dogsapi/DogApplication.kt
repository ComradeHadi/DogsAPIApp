package com.hadi.dogsapi

import android.app.Application


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