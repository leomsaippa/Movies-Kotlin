package com.lsaippa.movieskotlin.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MoviesResponse(
    @SerializedName("page") var page : Int,
    @SerializedName("total_results") var total_results : Int,
    @SerializedName("total_pages") var total_pages : Int,
    @SerializedName("results") var results : ArrayList<Results>

):Parcelable