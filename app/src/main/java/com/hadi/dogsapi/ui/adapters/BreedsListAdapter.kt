package com.hadi.dogsapi.ui.adapters

import com.hadi.dogsapi.data.ServerDataClasses
import com.hadi.dogsapi.databinding.BreedItemBinding
import com.hadi.dogsapi.viewModels.BaseBreedViewModel
import com.hadi.dogsapi.viewModels.MainBreedViewModel

/**
 * @author comrade hadi
 */
class BreedsListAdapter(override var clickListener: OnBreedClickListener? = null) : BaseListAdapter<ServerDataClasses.Breed>() {

    override var list: List<ServerDataClasses.Breed> = listOf()

    override fun initViewHolder(binding: BreedItemBinding, clickListener: OnBreedClickListener?): ViewHolder<ServerDataClasses.Breed> {
        return BreedViewHolder(binding, clickListener)
    }

    class BreedViewHolder(override var binding: BreedItemBinding, override var clickListener: OnBreedClickListener?):
        ViewHolder<ServerDataClasses.Breed>(binding, clickListener){

        override fun createViewModel(item: ServerDataClasses.Breed): BaseBreedViewModel<ServerDataClasses.Breed> {
            return MainBreedViewModel(item)
        }
    }
}