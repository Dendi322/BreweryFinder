package com.ua.horishnii.breweryfinder.screens.breweries_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ua.horishnii.breweryfinder.db.Brewery
import com.ua.horishnii.breweryfinder.repositories.BreweryRepository


class BreweriesListViewModel : ViewModel() {
    val breweryListLiveData: LiveData<List<Brewery>> by lazy {
        BreweryRepository.getBreweriesLiveData()
    }

    init {
        syncBreweriesListWithApi()
    }

    fun syncBreweriesListWithApi() {
        BreweryRepository.syncBreweriesListWithApi()
    }
}
