package com.ua.horishnii.breweryfinder.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "brewery")
data class Brewery (

    @PrimaryKey
    var id: Int? = null,

    @ColumnInfo(name = "name")
    var name: String? = null,

    @ColumnInfo(name = "brewery_type")
    var breweryType: String? = null,

    @ColumnInfo(name = "street")
    var street: String? = null,

    @ColumnInfo(name = "city")
    var city: String? = null,

    @ColumnInfo(name = "state")
    var state: String? = null,

    @ColumnInfo(name = "postal_code")
    var postalCode: String? = null,

    @ColumnInfo(name = "country")
    var country: String? = null,

    @ColumnInfo(name = "longitude")
    var longitude: Double? = null,

    @ColumnInfo(name = "latitude")
    var latitude: Double? = null,

    @ColumnInfo(name = "phone")
    var phone: String? = null,

    @ColumnInfo(name = "websiteUrl")
    var websiteUrl: String? = null,

    @ColumnInfo(name = "updated_at")
    var updatedAt: String? = null,

    @ColumnInfo(name = "tagList")
    var tagList: List<String?>? = null
)