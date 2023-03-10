package com.wolox.openpaytechdemo.usecases

import com.wolox.openpaytechdemo.models.MovieListModel
import com.wolox.openpaytechdemo.repository.MoviesRepository
import com.wolox.openpaytechdemo.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response

open class MoviesBaseUseCase {

    val moviesRepository = MoviesRepository()

    fun moviesFlow(result: Response<MovieListModel>): Flow<DataState<MovieListModel>> = flow {
        emit(DataState.Loading())
        if (result.isSuccessful) {
            emit(DataState.Success(result.body()!!))
        } else {
            emit(DataState.Error(result.errorBody().toString()))
        }
    }.catch {
        emit(DataState.Error("Error"))
    }
}
