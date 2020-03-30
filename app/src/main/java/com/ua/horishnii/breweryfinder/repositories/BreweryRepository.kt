package com.ua.horishnii.breweryfinder.repositories

import androidx.lifecycle.LiveData
import com.ua.horishnii.breweryfinder.BreweryFinderApp
import com.ua.horishnii.breweryfinder.api.pojo.BreweryPojo
import com.ua.horishnii.breweryfinder.db.Brewery
import com.ua.horishnii.breweryfinder.db.BreweryDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

object BreweryRepository {

    fun breweryPojoListToBreweryListConverter(breweryPojoList: List<BreweryPojo>): List<Brewery> {
        val breweryList = ArrayList<Brewery>(breweryPojoList.size)
        breweryPojoList.forEach() {
            breweryList.add(
                Brewery(
                    it.id,
                    it.name,
                    it.breweryType,
                    it.street,
                    it.city,
                    it.state,
                    it.postalCode,
                    it.country,
                    it.longitude,
                    it.latitude,
                    it.phone,
                    it.websiteUrl,
                    it.updatedAt,
                    it.tagList
                )
            )
        }
        return breweryList;
    }

    fun syncBreweriesListWithApi() {
        BreweryFinderApp.sOpenBreweryApi?.getBreweries()
            ?.enqueue(object : Callback<List<BreweryPojo>> {

                override fun onFailure(call: Call<List<BreweryPojo>>, t: Throwable) {
                    Timber.d(t)
                }

                override fun onResponse(
                    call: Call<List<BreweryPojo>>,
                    response: Response<List<BreweryPojo>>
                ) {
                    GlobalScope.launch {
                        BreweryDatabase.sAppDatabase.getBreweryDao()
                            .insertAll(response.body()?.let {
                                breweryPojoListToBreweryListConverter(
                                    it
                                )
                            })
                    }
                }
            })
    }

    fun getBreweriesLiveData(): LiveData<List<Brewery>> {
        return BreweryDatabase.sAppDatabase.getBreweryDao().getBreweriesLiveData()
    }
}