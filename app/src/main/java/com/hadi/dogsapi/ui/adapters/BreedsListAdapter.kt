package com.hadi.dogsapi.ui.adapters

import com.hadi.dogsapi.data.DataClasses
import com.hadi.dogsapi.databinding.BreedItemBinding
import com.hadi.dogsapi.viewModels.BaseBreedViewModel
import com.hadi.dogsapi.viewModels.MainBreedViewModel

/**
 * @author comrade hadi
 */
class BreedsListAdapter(override var clickListener: OnBreedClickListener? = null) : BaseListAdapter<DataClasses.Breed>() {

    override var list: List<DataClasses.Breed> = listOf()

    override fun initViewHolder(binding: BreedItemBinding, clickListener: OnBreedClickListener?): ViewHolder<DataClasses.Breed> {
        return BreedViewHolder(binding, clickListener)
    }

    class BreedViewHolder(override var binding: BreedItemBinding, override var clickListener: OnBreedClickListener?):
        ViewHolder<DataClasses.Breed>(binding, clickListener){

        override fun createViewModel(item: DataClasses.Breed): BaseBreedViewModel<DataClasses.Breed> {
            return MainBreedViewModel(item)
        }
    }
}