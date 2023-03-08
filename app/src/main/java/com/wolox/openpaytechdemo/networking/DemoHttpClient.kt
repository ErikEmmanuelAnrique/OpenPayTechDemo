package com.wolox.openpaytechdemo.networking

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DemoHttpClient {

    private const val BASE_URL = "https://api.themoviedb.org/"

    private val httpClient = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getClient(): Retrofit {
        val mOkHttpClient = OkHttpClient
            .Builder()
            .build()

        return httpClient
            .newBuilder()
            .client(mOkHttpClient)
            .build()
    }
}
