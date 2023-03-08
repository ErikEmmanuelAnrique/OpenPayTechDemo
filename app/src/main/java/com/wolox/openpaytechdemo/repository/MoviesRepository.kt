package com.wolox.openpaytechdemo.repository

import com.wolox.openpaytechdemo.interfaces.MoviesApi
import com.wolox.openpaytechdemo.networking.DemoHttpClient

class MoviesRepository {
    private val key = "1e9de53faa2659a8fa02fa870fb73a22"

    private val moviesService: MoviesApi
        get() {
            return DemoHttpClient.getClient().newBuilder().build().create(MoviesApi::class.java)
        }

    suspend fun getPopularMovies() = moviesService.getPopularMovies(key)
    suspend fun getTopRatedMovies() = moviesService.getTopRatedMovies(key)
}