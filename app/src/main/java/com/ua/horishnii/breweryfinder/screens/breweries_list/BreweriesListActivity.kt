package com.ua.horishnii.breweryfinder.screens.breweries_list

import MyAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ua.horishnii.breweryfinder.R
import com.ua.horishnii.breweryfinder.db.Brewery
import kotlinx.android.synthetic.main.activity_breweries_list.*
import timber.log.Timber

class BreweriesListActivity : AppCompatActivity() {

    private val mViewModel: BreweriesListViewModel by lazy {
        ViewModelProvider(this).get(BreweriesListViewModel::class.java);
    }
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breweries_list)

        viewManager = LinearLayoutManager(this)
        viewAdapter = MyAdapter()
        recyclerView = recycler_breweries.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }

        mViewModel.breweryListLiveData.observe(this, Observer {
            Timber.d("Observer on Activity")
            (viewAdapter as MyAdapter).setData(it)
        })

    }
}
