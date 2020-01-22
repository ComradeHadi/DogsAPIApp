package com.hadi.dogsapi.ui

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.hadi.dogsapi.DogApplication
import com.hadi.dogsapi.dagger.AppComponent
import com.hadi.dogsapi.dagger.ViewModelFactory

import javax.inject.Inject

/**
 * @author comrade hadi
 */
open class BaseActivity : FragmentActivity() {

    @Inject
    protected lateinit var viewModeFactory: ViewModelFactory

    protected val appComponent: AppComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        (this.application as DogApplication).appComponent
    }
}