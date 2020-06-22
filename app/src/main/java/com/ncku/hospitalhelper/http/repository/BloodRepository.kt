package com.ncku.hospitalhelper.http.repository

import com.mvvm.model.remote.ApiResponse
import com.ncku.hospitalhelper.http.ResponseCallback
import com.ncku.hospitalhelper.http.RetrofitClient
import okhttp3.MediaType
import okhttp3.RequestBody
import okhttp3.Response
import retrofit2.Call
import retrofit2.Callback

class BloodRepository : BloodDataSource {

    private var call: Call<ApiResponse>? = null

    override fun retrieveData(callback: ResponseCallback, areaNo: String, machineId: String) {
        call = RetrofitClient.build()?.getBlood(RequestBody.create(MediaType.parse("text/plain"), ""))
        call?.enqueue(object : Callback<ApiResponse> {
            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
//                LogUtils.info(t.message)
                callback.onError(t.message)
            }

            override fun onResponse(call: Call<ApiResponse>, response: retrofit2.Response<ApiResponse>) {
                response.body()?.let {
                    if (response.isSuccessful) {
                        callback.onSuccess(it)
                    } else {
                        callback.onError("Error")
                    }
                }
            }
        })
    }

    override fun cancel() {
        call?.let {
            it.cancel()
        }
    }
}
