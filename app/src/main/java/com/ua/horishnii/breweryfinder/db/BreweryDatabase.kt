package com.ua.horishnii.breweryfinder.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ua.horishnii.breweryfinder.BreweryFinderApp

@Database(entities = [Brewery::class], version = 1)
@TypeConverters(TagListConverters::class)
abstract class BreweryDatabase : RoomDatabase() {
    companion object{
        val sAppDatabase = Room.databaseBuilder(
            BreweryFinderApp.sAppContext,
            BreweryDatabase::class.java, "brewery_db"
        ).build()
    }
    abstract fun getBreweryDao():BreweryDao
}