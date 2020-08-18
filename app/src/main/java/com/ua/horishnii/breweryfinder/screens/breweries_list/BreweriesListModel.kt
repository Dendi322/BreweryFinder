package com.ua.horishnii.breweryfinder.screens.breweries_list

import androidx.lifecycle.LiveData
import com.ua.horishnii.breweryfinder.db.Brewery

class BreweriesListModel {
    var lastSearchResults: LiveData<List<Brewery>>?=null
}