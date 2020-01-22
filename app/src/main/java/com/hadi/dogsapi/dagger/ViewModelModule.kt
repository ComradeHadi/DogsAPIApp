package com.hadi.dogsapi.dagger

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hadi.dogsapi.viewModels.DetailViewModel
import com.hadi.dogsapi.viewModels.ListViewModel
import com.hadi.dogsapi.viewModels.SubBreedImageViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * @author comrade hadi
 */
@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ListViewModel::class)
    abstract fun bindListViewModel(listViewModel: ListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    abstract fun bindDetailViewModel(detailViewModel: DetailViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SubBreedImageViewModel::class)
    abstract fun bindSubBreedImageViewModel(subBreedImageViewModel: SubBreedImageViewModel): ViewModel
}