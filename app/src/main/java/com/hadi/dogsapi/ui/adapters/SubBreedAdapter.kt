package com.hadi.dogsapi.ui.adapters

import com.hadi.dogsapi.databinding.BreedItemBinding
import com.hadi.dogsapi.viewModels.BaseBreedViewModel
import com.hadi.dogsapi.viewModels.SubBreedViewModel

/**
 * @author comrade hadi
 */
class SubBreedAdapter(override var clickListener: OnBreedClickListener? = null): BaseListAdapter<String>() {

    override var list: List<String> = listOf()

    override fun initViewHolder(binding: BreedItemBinding, clickListener: OnBreedClickListener?): ViewHolder<String> {
        return BreedViewHolder(binding, clickListener)
    }

    class BreedViewHolder(override var binding: BreedItemBinding, override var clickListener: OnBreedClickListener?):
        ViewHolder<String>(binding, clickListener){

        override fun createViewModel(item: String): BaseBreedViewModel<String> {
            return SubBreedViewModel(item)
        }
    }
}