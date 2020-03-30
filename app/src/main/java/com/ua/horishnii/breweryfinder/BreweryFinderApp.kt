package com.ua.horishnii.breweryfinder

import android.app.Application
import android.content.Context
import com.ua.horishnii.breweryfinder.api.OpenBreweryApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber


class BreweryFinderApp : Application() {
    companion object {
        var sOpenBreweryApi: OpenBreweryApi? = null
        lateinit var sAppContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        sAppContext = this.applicationContext
        timberInit()
        retrofitInit()
    }

    private fun retrofitInit() {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE
        )

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        val mRetrofit = Retrofit.Builder()
            .baseUrl("https://api.openbrewerydb.org")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        sOpenBreweryApi = mRetrofit.create(OpenBreweryApi::class.java)
    }

    private fun timberInit() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(object : Timber.Tree() {
                override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
                    // do nothing, no logs for production
                }
            })
        }
    }

}