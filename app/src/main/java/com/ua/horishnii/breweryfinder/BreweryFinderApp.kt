package com.ua.horishnii.breweryfinder

import android.app.Application
import com.ua.horishnii.breweryfinder.api.OpenBreweryApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BreweryFinderApp : Application() {
    companion object {
        var sOpenBreweryApi: OpenBreweryApi? = null
    }

    override fun onCreate() {
        super.onCreate()
        retrofitInit()
    }

    private fun retrofitInit() {
        val mRetrofit = Retrofit.Builder()
            .baseUrl("https://api.openbrewerydb.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        sOpenBreweryApi = mRetrofit.create(OpenBreweryApi::class.java)
    }
}