package com.ua.horishnii.breweryfinder.repositories

import androidx.lifecycle.LiveData
import com.ua.horishnii.breweryfinder.BreweryFinderApp
import com.ua.horishnii.breweryfinder.db.Brewery
import com.ua.horishnii.breweryfinder.db.BreweryDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

object BreweryRepository {

    fun getBreweriesLiveData(): LiveData<List<Brewery>> {
        syncBreweriesListWithApi()
        return BreweryDatabase.sAppDatabase.getBreweryDao().getBreweriesLiveData()
    }

    fun getBreweriesByNameLiveData(name: String): LiveData<List<Brewery>> {
        syncBreweriesByNameWithApi(name)
        return BreweryDatabase.sAppDatabase.getBreweryDao().getBreweriesByName("%$name%")
    }

    fun syncBreweriesListWithApi() {
        BreweryFinderApp.sOpenBreweryApi?.getBreweries()?.enqueue(object : Callback<List<Brewery>> {

            override fun onFailure(call: Call<List<Brewery>>, t: Throwable) {
                Timber.d(t)
            }

            override fun onResponse(call: Call<List<Brewery>>, response: Response<List<Brewery>>) {
                GlobalScope.launch {
                    BreweryDatabase.sAppDatabase.getBreweryDao().insertAll(response.body())
                }
            }
        })
    }

    fun syncBreweriesByNameWithApi(name: String) {
        BreweryFinderApp.sOpenBreweryApi?.getBreweriesByName(name)
            ?.enqueue(object : Callback<List<Brewery>> {
                override fun onFailure(call: Call<List<Brewery>>, t: Throwable) {
                    Timber.d(t)
                }

                override fun onResponse(call: Call<List<Brewery>>, response: Response<List<Brewery>>) {
                    GlobalScope.launch {
                        BreweryDatabase.sAppDatabase.getBreweryDao().insertAll(response.body())
                    }
                }
            })
    }
}