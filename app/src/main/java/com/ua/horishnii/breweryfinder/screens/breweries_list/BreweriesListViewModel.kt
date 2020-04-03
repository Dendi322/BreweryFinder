package com.ua.horishnii.breweryfinder.screens.breweries_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ua.horishnii.breweryfinder.db.Brewery
import com.ua.horishnii.breweryfinder.repositories.BreweryRepository


class BreweriesListViewModel : ViewModel() {
    val breweryListLiveData: LiveData<List<Brewery>> by lazy {
        BreweryRepository.getBreweriesLiveData()
    }


    fun syncBreweriesListWithApi() {
        BreweryRepository.syncBreweriesListWithApi()
    }

    fun getBreweriesByName(name:String): LiveData<List<Brewery>> {
       return BreweryRepository.getBreweriesByNameLiveData(name)
    }
}
