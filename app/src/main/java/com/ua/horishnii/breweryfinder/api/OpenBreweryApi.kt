package com.ua.horishnii.breweryfinder.api

import com.ua.horishnii.breweryfinder.db.Brewery
import retrofit2.Call
import retrofit2.http.GET

interface OpenBreweryApi {
    @GET("/breweries")
    fun getBreweries(): Call<List<Brewery>>
}