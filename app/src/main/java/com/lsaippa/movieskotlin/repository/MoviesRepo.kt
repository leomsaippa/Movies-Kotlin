package com.lsaippa.movieskotlin.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.lsaippa.movieskotlin.BuildConfig
import com.lsaippa.movieskotlin.model.MoviesApi
import com.lsaippa.movieskotlin.model.MoviesResponse
import com.lsaippa.movieskotlin.model.Results
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesRepo(private val context: Context, private val moviesApi: MoviesApi) {

    fun getMovies(data: MutableLiveData<MoviesResponse>){
        moviesApi.getMovies(BuildConfig.API_KEY).enqueue(object : Callback<MoviesResponse>{
            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                Log.e("onFailure", "onFailure")
            }

            override fun onResponse(call: Call<MoviesResponse>, response: Response<MoviesResponse>) {
                if (response.isSuccessful){
                    data.value = response.body()
                } else {
                    val result = Results("", false,0.0,"", 0.0,
                        "","","", false,"","")
                    val listResult = ArrayList<Results>()
                    listResult.add(result)
                    data.value = MoviesResponse(1,1,1,listResult)
                }
            }

        })
    }
}
