package com.wolox.openpaytechdemo.usecases

import com.wolox.openpaytechdemo.models.MovieListModel
import com.wolox.openpaytechdemo.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class GetPopularMovies : MoviesBaseUseCase() {
    suspend fun get() = moviesFlow(moviesRepository.getPopularMovies())
}
