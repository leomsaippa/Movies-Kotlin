package com.lsaippa.movieskotlin.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lsaippa.movieskotlin.model.MoviesResponse
import com.lsaippa.movieskotlin.repository.MoviesRepo

class MainActivityViewModel(private val moviesRepo: MoviesRepo) : ViewModel() {

    var moviesResponseLiveData = MutableLiveData<MoviesResponse>()

    fun getMovies(){
        moviesRepo.getMovies(moviesResponseLiveData)
    }

}