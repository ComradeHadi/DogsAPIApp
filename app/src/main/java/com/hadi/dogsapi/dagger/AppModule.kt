package com.hadi.dogsapi

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author comrade hadi
 */
@Module
class AppModule(private val app: Application){
    @Provides
    @Singleton
    fun provideContext(): Context = app
}