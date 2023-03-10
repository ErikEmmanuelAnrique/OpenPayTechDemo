package com.wolox.openpaytechdemo.usecases

import com.wolox.openpaytechdemo.models.MovieListModel
import com.wolox.openpaytechdemo.util.DataState
import kotlinx.coroutines.flow.Flow

class GetTopRatedMovies : MoviesBaseUseCase() {

    suspend fun get() = moviesFlow(moviesRepository.getTopRatedMovies())
}
