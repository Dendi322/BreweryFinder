package com.ua.horishnii.breweryfinder.api.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BreweryPojo(
    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("name")
    @Expose
    var name: String? = null,

    @SerializedName("brewery_type")
    @Expose
    var breweryType: String? = null,

    @SerializedName("street")
    @Expose
    var street: String? = null,

    @SerializedName("city")
    @Expose
    var city: String? = null,

    @SerializedName("state")
    @Expose
    var state: String? = null,

    @SerializedName("postal_code")
    @Expose
    var postalCode: String? = null,

    @SerializedName("country")
    @Expose
    var country: String? = null,

    @SerializedName("longitude")
    @Expose
    var longitude: Double? = null,

    @SerializedName("latitude")
    @Expose
    var latitude: Double? = null,

    @SerializedName("phone")
    @Expose
    var phone: String? = null,

    @SerializedName("website_url")
    @Expose
    var websiteUrl: String? = null,

    @SerializedName("updated_at")
    @Expose
    var updatedAt: String? = null,

    @SerializedName("tag_list")
    @Expose
    var tagList: List<String?>? = null
)
