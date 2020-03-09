package com.lsaippa.movieskotlin.di

import com.lsaippa.movieskotlin.repository.MoviesRepo
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val repositoryModule = module {
    single { MoviesRepo(androidContext(), moviesApi = get()) }

//    single { LocationHandler() }
}