package com.ua.horishnii.breweryfinder.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BreweryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(breweriesList: List<Brewery?>?)

    @Query("SELECT * FROM brewery ORDER BY name DESC")
    fun getBreweriesLiveData(): LiveData<List<Brewery>>
}