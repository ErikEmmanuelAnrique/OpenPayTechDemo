package com.wolox.openpaytechdemo.networking

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor: Interceptor {

    /**
     * Interceptor class for setting of the headers for every request
     */
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
            .addHeader("api_key", "1e9de53faa2659a8fa02fa870fb73a22")
            .build()
        return chain.proceed(request)
    }
}