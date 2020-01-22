package com.hadi.dogsapi.ui

import android.os.Bundle
import android.os.Parcelable
import android.view.View
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hadi.dogsapi.NavigationUtils
import com.hadi.dogsapi.R
import com.hadi.dogsapi.data.ServerDataClasses
import com.hadi.dogsapi.databinding.ActivityMainBinding
import com.hadi.dogsapi.ui.adapters.BaseListAdapter
import com.hadi.dogsapi.ui.adapters.BreedsListAdapter
import com.hadi.dogsapi.viewModels.ListViewModel

class MainActivity : BaseActivity(), BaseListAdapter.OnBreedClickListener {

    private lateinit var listViewModel: ListViewModel
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val adapter = BreedsListAdapter(this)

        initRecyclerView(adapter)

        initViewModel(adapter)
    }

    private fun initRecyclerView(adapter: BreedsListAdapter) {
        val recyclerView = activityMainBinding.breedRecyclerView

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayout.VERTICAL
            ) as RecyclerView.ItemDecoration
        )
    }

    private fun initViewModel(adapter: BreedsListAdapter) {
       // activityMainBinding.lifecycleOwner = this




        listViewModel = ViewModelProviders.of(this, viewModeFactory).get(ListViewModel::class.java)
        activityMainBinding.viewModel = listViewModel

        listViewModel.getBreedsLiveData().observe(this, Observer<List<ServerDataClasses.Breed>> { breeds ->
            breeds?.let {
                adapter.setItems(it)
            }
        })

        listViewModel.getDataStateLiveData().observe(this, Observer { state ->
            state.let {
                if (it.isFailed){
                    activityMainBinding.errorView.visibility = View.VISIBLE
                }
            }
        })
    }

    override fun onBreedClicked(item: Any?) {
        val fragmentManager = supportFragmentManager
        val args = Bundle()
        args.putParcelable(NavigationUtils.BREED_KEY, item as Parcelable?)
        val fragment =  BreedDetailFragment.newInstance()
        fragment.arguments = args
        val ft = fragmentManager.beginTransaction()
        ft.add(activityMainBinding.rootLayout.id, fragment, BreedDetailFragment.TAG)
        ft.addToBackStack(BreedDetailFragment.TAG)
        ft.commit()
    }
}
