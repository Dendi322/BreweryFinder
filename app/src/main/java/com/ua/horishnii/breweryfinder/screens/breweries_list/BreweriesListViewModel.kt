package com.ua.horishnii.breweryfinder.screens.breweries_list

import androidx.lifecycle.ViewModel
import com.ua.horishnii.breweryfinder.repositories.BreweryRepository


class BreweriesListViewModel : ViewModel() {
    val model:BreweriesListModel = BreweriesListModel()

    init {
        model.breweryListLiveData =  BreweryRepository.getBreweriesLiveData()
        BreweryRepository.syncBreweriesListWithApi()
    }

    fun getBreweriesByName(name:String) {
        model.lastSearchResults = BreweryRepository.getBreweriesByNameLiveData(name)
        BreweryRepository.syncBreweriesByNameWithApi(name)
    }
}
