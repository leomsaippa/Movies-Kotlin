package com.lsaippa.movieskotlin.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {
    @GET("movie/popular")
    fun getMovies(@Query("api_key") api_key: String):Call<MoviesResponse>
}