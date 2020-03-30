package com.ua.horishnii.breweryfinder.screens.breweries_list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.ua.horishnii.breweryfinder.R
import com.ua.horishnii.breweryfinder.db.Brewery
import com.ua.horishnii.breweryfinder.repositories.BreweryRepository
import timber.log.Timber

class BreweriesListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breweries_list)
        BreweryRepository.syncBreweriesListWithApi()
        BreweryRepository.getBreweriesLiveData().observe(this,
            Observer<List<Brewery>> { t -> t?.forEach { Timber.d("on Activity%s", it.toString()) } })

    }
}
