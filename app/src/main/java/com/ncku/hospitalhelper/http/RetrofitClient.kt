package com.ncku.hospitalhelper.http

/**
 * Created by Kevin on 2020-02-15.
 */

import java.util.concurrent.TimeUnit
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

        private val API_BASE_URL = "https://www.hosp.ncku.edu.tw/nckm/BloodCounterMsg/default.aspx/"

    private var apiServices: ApiServices? = null

    fun build(): ApiServices? {
        var builder: Retrofit.Builder = Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
        apiServices = getApiService(builder)
        return apiServices
    }

    private fun getApiService(builder: Retrofit.Builder): ApiServices? {
        var httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
        httpClient.addInterceptor(interceptor()).connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)

        var retrofit: Retrofit = builder.client(httpClient.build()).build()

        apiServices = retrofit.create(
                ApiServices::class.java)
        return apiServices as ApiServices
    }

    private fun interceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }
}
