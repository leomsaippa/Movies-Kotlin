package com.lsaippa.movieskotlin.di

import com.lsaippa.movieskotlin.ui.main.MainActivityViewModel
import com.lsaippa.movieskotlin.ui.main.MoviesListFragmentViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
   viewModel { MoviesListFragmentViewModel(get()) }
}