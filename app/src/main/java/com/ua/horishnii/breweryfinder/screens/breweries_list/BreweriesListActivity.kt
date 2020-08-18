package com.ua.horishnii.breweryfinder.screens.breweries_list

import BreweriesListAdapter
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.TextView.OnEditorActionListener
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ua.horishnii.breweryfinder.R
import kotlinx.android.synthetic.main.activity_breweries_list.*


class BreweriesListActivity : AppCompatActivity() {

    private val mViewModel: BreweriesListViewModel by lazy {
        ViewModelProvider(this).get(BreweriesListViewModel::class.java)
    }
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breweries_list)

        viewManager = LinearLayoutManager(this)
        viewAdapter = BreweriesListAdapter()
        recyclerView = recycler_breweries.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }
        edit_search.setOnEditorActionListener(OnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                performSearchByName(edit_search.text.toString())
                return@OnEditorActionListener true
            }
            false
        })
        performSearchByName("")
    }

    private fun performSearchByName(name: String) {
        mViewModel.model.lastSearchResults?.removeObservers(this)
        mViewModel.getBreweriesByName(name)
        mViewModel.model.lastSearchResults?.observe(
            this, Observer((viewAdapter as BreweriesListAdapter)::setData)
        )
    }
}
