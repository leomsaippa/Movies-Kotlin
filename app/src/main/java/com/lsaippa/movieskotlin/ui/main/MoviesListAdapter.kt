package com.lsaippa.movieskotlin.ui.main

import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.lsaippa.movieskotlin.R
import com.lsaippa.movieskotlin.databinding.MovieCardItemBinding
import com.lsaippa.movieskotlin.model.MoviesResponse
import com.lsaippa.movieskotlin.model.Results

class MoviesAdapter(
    private val movieClickCallback: ((MoviesResponse) -> Unit?)
): RecyclerView.Adapter<MoviesAdapterViewHolder>() {

    private var moviesListItems = ArrayList<Results>()

    fun setData(items: ArrayList<Results>) {
        this.moviesListItems = items
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesAdapterViewHolder {
        val binding: MovieCardItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.movie_card_item, parent, false
        )
        binding.root.setOnClickListener{
            Log.d("MoviesListAdapter", "MoviesListAdapter click")
            binding.movieResponse?.let {
                movieClickCallback?.invoke(it)
            }
        }
        return MoviesAdapterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return moviesListItems.size
    }

    override fun onBindViewHolder(holder: MoviesAdapterViewHolder, position: Int) {
        holder.binding.tvTitle.text = moviesListItems[position].title
    }


}
    class MoviesAdapterViewHolder(var binding: MovieCardItemBinding) : RecyclerView.ViewHolder(binding.root){

    }
