package com.wolox.openpaytechdemo.networking

import java.util.concurrent.TimeUnit
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DemoHttpClient {

    private const val

    val httpClient = Retrofit
        .Builder()
        .baseUrl("")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getClient(): Retrofit {
        val mOkHttpClient = OkHttpClient
            .Builder().build()

        return httpClient
            .newBuilder()
            .client(mOkHttpClient)
            .build()
    }
}