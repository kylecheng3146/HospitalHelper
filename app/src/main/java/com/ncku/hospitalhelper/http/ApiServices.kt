package com.ncku.hospitalhelper.http

import com.mvvm.model.remote.* // ktlint-disable
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by Kyle on 2020-02-15.
 */
interface ApiServices {
//    @GET("/api/museums/")
//    fun getMuseums(): Call<List<Museum>>

    //    @Headers(*arrayOf("Accept:*/*", "Content-Type: text/plain; charset=UTF-8"))
    @POST("/GetWaitPerson")
    fun getBlood(@Body body: RequestBody): Call<ApiResponse>?
    fun getPill(@Body body: RequestBody): Call<ApiResponse>?
}
