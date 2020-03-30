package com.ua.horishnii.breweryfinder.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


@Entity(tableName = "brewery")
data class Brewery(

    @SerializedName("id")
    @Expose
    @PrimaryKey
    var id: Int? = null,

    @SerializedName("name")
    @Expose
    @ColumnInfo(name = "name")
    var name: String? = null,

    @SerializedName("brewery_type")
    @Expose
    @ColumnInfo(name = "brewery_type")
    var breweryType: String? = null,

    @SerializedName("street")
    @Expose
    @ColumnInfo(name = "street")
    var street: String? = null,

    @SerializedName("city")
    @Expose
    @ColumnInfo(name = "city")
    var city: String? = null,

    @SerializedName("state")
    @Expose
    @ColumnInfo(name = "state")
    var state: String? = null,

    @SerializedName("postal_code")
    @Expose
    @ColumnInfo(name = "postal_code")
    var postalCode: String? = null,

    @SerializedName("country")
    @Expose
    @ColumnInfo(name = "country")
    var country: String? = null,

    @SerializedName("longitude")
    @Expose
    @ColumnInfo(name = "longitude")
    var longitude: Double? = null,

    @SerializedName("latitude")
    @Expose
    @ColumnInfo(name = "latitude")
    var latitude: Double? = null,

    @SerializedName("phone")
    @Expose
    @ColumnInfo(name = "phone")
    var phone: String? = null,


    @SerializedName("website_url")
    @Expose
    @ColumnInfo(name = "websiteUrl")
    var websiteUrl: String? = null,

    @SerializedName("updated_at")
    @Expose
    @ColumnInfo(name = "updated_at")
    var updatedAt: String? = null,

    @SerializedName("tag_list")
    @Expose
    @ColumnInfo(name = "tagList")
    var tagList: List<String?>? = null

)

class TagListConverters {
    private val separator = " "

    @TypeConverter
    fun fromTag(tagList: List<String?>): String {
        return tagList.joinToString(separator)
    }

    @TypeConverter
    fun toTag(data: String): List<String> {
        return data.split(separator)
    }
}