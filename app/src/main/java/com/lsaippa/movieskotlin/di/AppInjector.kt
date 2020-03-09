package com.lsaippa.movieskotlin.di

import com.lsaippa.movieskotlin.model.MoviesApi
import org.koin.dsl.module
import retrofit2.Retrofit

private val retrofit: Retrofit = createNetworkClient()


private val MOVIES_API: MoviesApi = retrofit.create(MoviesApi::class.java)

val networkModule = module {
    single { MOVIES_API }
}