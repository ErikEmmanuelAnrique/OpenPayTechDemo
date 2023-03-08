package com.wolox.openpaytechdemo.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.wolox.openpaytechdemo.databinding.FragmentMoviesBinding
import com.wolox.openpaytechdemo.models.Movie

class MoviesFragment : Fragment() {

    private lateinit var binding: FragmentMoviesBinding
    private val viewModel: MoviesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = FragmentMoviesBinding.inflate(layoutInflater)
        viewModel.getMovies()
        with(binding) {
            val popularMoviesObserver = Observer<List<Movie>> {
                popularMoviesCarousel.adapter = MoviesListAdapter(it)
            }
            viewModel.popularMoviesList.observe(this@MoviesFragment, popularMoviesObserver)
            popularMoviesCarousel.layoutManager = LinearLayoutManager(context).apply {
                orientation = LinearLayoutManager.HORIZONTAL
            }
            val topRatedMoviesObserver = Observer<List<Movie>> {
                topRatedMoviesCarousel.adapter = MoviesListAdapter(it)
            }
            viewModel.topRatedMoviesList.observe(this@MoviesFragment, topRatedMoviesObserver)
            topRatedMoviesCarousel.layoutManager = LinearLayoutManager(context).apply {
                orientation = LinearLayoutManager.HORIZONTAL
            }
            topRatedMoviesCarousel.adapter = MoviesListAdapter(listOf())
        }
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root
}
