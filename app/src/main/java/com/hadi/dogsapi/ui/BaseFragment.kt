package com.hadi.dogsapi.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.hadi.dogsapi.AppComponent
import com.hadi.dogsapi.DogApplication
import com.hadi.dogsapi.ViewModelFactory

import javax.inject.Inject

/**
 * @author comrade hadi
 */
abstract class BaseFragment: Fragment() {

    @Inject
    protected lateinit var viewModeFactory: ViewModelFactory

    protected val appComponent: AppComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        (activity!!.application as DogApplication).appComponent
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
    }
}