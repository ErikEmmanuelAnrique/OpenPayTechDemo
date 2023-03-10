package com.wolox.openpaytechdemo.ui.movies

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wolox.openpaytechdemo.models.Movie
import com.wolox.openpaytechdemo.models.MovieListModel
import com.wolox.openpaytechdemo.repository.MoviesRepository
import com.wolox.openpaytechdemo.usecases.GetPopularMovies
import com.wolox.openpaytechdemo.usecases.GetTopRatedMovies
import com.wolox.openpaytechdemo.util.DataState
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.cancellable
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import retrofit2.Response

class MoviesViewModel : ViewModel() {
    private val moviesRepository = MoviesRepository()
    private val topRatedMoviesUseCase = GetTopRatedMovies()
    private val popularMoviesUseCase = GetPopularMovies()

    private val _topRatedMoviesResponse: MutableLiveData<DataState<MovieListModel>> =
        MutableLiveData()
    val topRatedMoviesResponse: LiveData<DataState<MovieListModel>> = _topRatedMoviesResponse
    private val _popularMoviesResponse: MutableLiveData<DataState<MovieListModel>> =
        MutableLiveData()
    val popularMoviesResponse: LiveData<DataState<MovieListModel>> = _popularMoviesResponse
    private val _topRatedMoviesList: MutableLiveData<List<Movie>> = MutableLiveData(listOf())
    val topRatedMoviesList: LiveData<List<Movie>> = _topRatedMoviesList
    private val _popularMoviesList: MutableLiveData<List<Movie>> = MutableLiveData(listOf())
    val popularMoviesList: LiveData<List<Movie>> = _popularMoviesList

    //Todo agregar movie dto

    fun getMovies() {
        viewModelScope.launch {
            try {
                topRatedMoviesUseCase.get().cancellable().collect() { result ->
                    _topRatedMoviesResponse.value = result
                    result.data?.let {
                        _topRatedMoviesList.value = it.results
                    }
                }
            } catch (e: CancellationException) {

            }
            try {
                popularMoviesUseCase.get().cancellable().collect() { result ->
                    _popularMoviesResponse.value = result
                    result.data?.let {
                        _popularMoviesList.value = it.results
                    }
                }
            } catch (e: CancellationException) {

            }
        }
    }
}
