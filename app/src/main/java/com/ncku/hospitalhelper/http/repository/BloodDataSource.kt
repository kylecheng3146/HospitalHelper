package com.ncku.hospitalhelper.http.repository

import com.ncku.hospitalhelper.http.ResponseCallback

interface BloodDataSource {
    fun retrieveData(callback: ResponseCallback, areaNo: String, machineId: String)
    fun cancel()
}
