package com.hadi.dogsapi.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.hadi.dogsapi.NavigationUtils
import com.hadi.dogsapi.R
import com.hadi.dogsapi.data.ServerDataClasses
import com.hadi.dogsapi.databinding.FragmentSubbreedImageBinding
import com.hadi.dogsapi.ui.adapters.BreedImageAdapter
import com.hadi.dogsapi.viewModels.SubBreedImageViewModel

/**
 * @author comrade hadi
 */
class SubBreedImageFragment: BaseFragment() {

    companion object{
        val TAG = SubBreedImageFragment::class.java.canonicalName
        fun newInstance(): SubBreedImageFragment {
            return SubBreedImageFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentSubbreedImageBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_subbreed_image, container, false)
        val imageAdapter = initViewPager(binding)
        initViewModel(binding, imageAdapter)
        binding.rootLayout.setOnClickListener { view ->  activity!!.onBackPressed()}

        return binding.root
    }

    private fun initViewPager(binding: FragmentSubbreedImageBinding): BreedImageAdapter {
        val viewPager = binding.subBreedViewPager
        val imageAdapter = BreedImageAdapter(context)
        viewPager.adapter = imageAdapter
        return imageAdapter
    }

    fun initViewModel(binding: FragmentSubbreedImageBinding, adapter: BreedImageAdapter){
        val subBreedImageViewModel = ViewModelProviders.of(this, viewModeFactory).get(SubBreedImageViewModel::class.java)
        binding.viewModel = subBreedImageViewModel
        subBreedImageViewModel.subBreed = getStringFromArgs()
        subBreedImageViewModel.breed = getBreedFromArgs()

        subBreedImageViewModel.getImageUrlLiveData().observe(this, Observer<List<String>>{ images ->
            images?.let {
                adapter.setImages(it)
            }
        })
    }

    private fun getStringFromArgs(): String {
        val bundle = arguments
        val name = bundle?.get(NavigationUtils.SUB_BREED_KEY) as String
        return name
    }

    private fun getBreedFromArgs(): ServerDataClasses.Breed {
        val bundle = arguments
        val breed = bundle?.get(NavigationUtils.BREED_KEY) as ServerDataClasses.Breed
        return breed
    }
}