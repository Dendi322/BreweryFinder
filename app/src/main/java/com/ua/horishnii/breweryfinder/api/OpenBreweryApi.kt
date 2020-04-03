package com.ua.horishnii.breweryfinder.api

import com.ua.horishnii.breweryfinder.db.Brewery
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenBreweryApi {
    @GET("/breweries")
    fun getBreweries(): Call<List<Brewery>>

    @GET("/breweries")
    fun getBreweriesByName(@Query("by_name") name:String): Call<List<Brewery>>
}