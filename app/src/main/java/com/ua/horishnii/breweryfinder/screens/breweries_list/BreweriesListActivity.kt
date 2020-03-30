package com.ua.horishnii.breweryfinder.screens.breweries_list

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ua.horishnii.breweryfinder.BreweryFinderApp
import com.ua.horishnii.breweryfinder.R
import com.ua.horishnii.breweryfinder.api.pojo.BreweryPojo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BreweriesListActivity : AppCompatActivity() {
    companion object {
        const val TAG = "BreweriesListActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breweries_list)

        BreweryFinderApp.sOpenBreweryApi?.getBreweries()
            ?.enqueue(object : Callback<List<BreweryPojo>> {

                override fun onFailure(call: Call<List<BreweryPojo>>, t: Throwable) {
                    Log.d(TAG, "error" + t.localizedMessage)
                }

                override fun onResponse(call: Call<List<BreweryPojo>>, response: Response<List<BreweryPojo>>) {
                    response.body()?.forEach {
                        Log.d(TAG, "response $it")
                    }
                }
            })
    }
}
