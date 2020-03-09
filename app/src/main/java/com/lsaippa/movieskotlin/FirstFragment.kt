package com.lsaippa.movieskotlin

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.lsaippa.movieskotlin.databinding.FragmentFirstBinding
import com.lsaippa.movieskotlin.model.Results
import com.lsaippa.movieskotlin.ui.main.MoviesAdapter
import com.lsaippa.movieskotlin.ui.main.MoviesListFragmentViewModel
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private val moviesListViewModel: MoviesListFragmentViewModel by viewModel()
    private val adapter = MoviesAdapter { movieResponse -> teste()
    }

    private fun teste() {

        Log.d("este ", "este" )

    }

    private lateinit var linearLayoutManager: LinearLayoutManager

    lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_first, container, false)

        val view = binding.root
        configureViewModel()
        configureViews()

        moviesListViewModel.getMovies()

        return view
    }

    private fun configureViews() {
        binding.lifecycleOwner = this
        binding.rvMoviesList.adapter = adapter
    }

    private fun configureViewModel() {
        moviesListViewModel.moviesResponseLiveData.observe(
            this,
            Observer {
                onMoviesRecieved(it.results)
            }
        )
    }

    private fun onMoviesRecieved(results: ArrayList<Results>) {
        results.let {
            adapter.setData(it)
        }
        Log.d("teste", "onMoviesrecieved")
    }

    //    private fun onMoviesRecieved(moviesList: ArrayList<MovieResult>){
//
//    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        view.findViewById<Button>(R.id.button_first).setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }
    }
}
