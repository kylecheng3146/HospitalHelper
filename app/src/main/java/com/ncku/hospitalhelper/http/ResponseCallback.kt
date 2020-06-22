package com.ncku.hospitalhelper.http

/**
 * Created by Kyle on 2020-02-15.
 */

interface ResponseCallback {
    fun onSuccess(obj: Any?)
    fun onError(obj: Any?)
}
