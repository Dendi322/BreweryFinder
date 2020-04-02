package com.ua.horishnii.breweryfinder.screens.breweries_list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ua.horishnii.breweryfinder.R
import com.ua.horishnii.breweryfinder.db.Brewery
import timber.log.Timber

class BreweriesListActivity : AppCompatActivity() {

    private val mViewModel: BreweriesListViewModel by lazy {
        ViewModelProvider(this).get(BreweriesListViewModel::class.java);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breweries_list)
        mViewModel.breweryListLiveData.observe(this, Observer<List<Brewery>> {
            Timber.d("Observer on Activity")
        })
    }
}
