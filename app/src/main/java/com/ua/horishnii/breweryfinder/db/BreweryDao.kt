package com.ua.horishnii.breweryfinder.db

import androidx.room.Insert
import androidx.room.OnConflictStrategy

interface BreweryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(breweriesList: List<Brewery?>?)
}