package com.lsaippa.movieskotlin

import android.app.Application
import com.lsaippa.movieskotlin.di.networkModule
import com.lsaippa.movieskotlin.di.repositoryModule
import com.lsaippa.movieskotlin.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class KotlinMoviesApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@KotlinMoviesApp)
            modules(listOf(repositoryModule, networkModule, viewModelModule))
        }
    }
}