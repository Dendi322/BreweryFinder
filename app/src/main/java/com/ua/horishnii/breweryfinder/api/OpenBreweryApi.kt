package com.ua.horishnii.breweryfinder.api

import com.ua.horishnii.breweryfinder.api.pojo.BreweryPojo
import retrofit2.Call
import retrofit2.http.GET

interface OpenBreweryApi {
    @GET("/breweries")
    fun getBreweries(): Call<List<BreweryPojo>>
}