package com.wolox.openpaytechdemo.interfaces

import com.wolox.openpaytechdemo.models.MovieListModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {
    @GET("3/movie/top_rated")
    suspend fun getTopRatedMovies(@Query("api_key") key: String): Response<MovieListModel>

    @GET("3/movie/popular")
    suspend fun getPopularMovies(@Query("api_key") key: String): Response<MovieListModel>
}
