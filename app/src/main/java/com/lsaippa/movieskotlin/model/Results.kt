package com.lsaippa.movieskotlin.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Results (
    @SerializedName("vote_count") var vote_count: String,
    @SerializedName("video") var video: Boolean,
    @SerializedName("vote_average") var vote_average: Double,
    @SerializedName("title") var title: String,
    @SerializedName("popularity") var popularity: Double,
    @SerializedName("poster_path") var poster_path: String,
    @SerializedName("original_language") var original_language: String,
    @SerializedName("original_title") var original_title: String,
    @SerializedName("adult") var adult: Boolean,
    @SerializedName("overview") var overview: String,
    @SerializedName("release_date") var release_date: String




) :Parcelable
