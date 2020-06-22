package com.ncku.hospitalhelper.utils

/**
 * Created by Kyle on 2020-02-10.
 */

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.ncku.hospitalhelper.R
import java.util.* // ktlint-disable

object CommonUtils {

    private val msgToasts = ArrayList<Toast>()
    lateinit var progressDialog: ProgressDialog
    var manager: FragmentManager? = null

    /**
     * 顯示提示訊息
     * @param activity [當前頁面]
     * @param msg [訊息]
     */
    fun showMessage(context: Context?, msg: String?) {
        val t = Toast.makeText(context, msg, Toast.LENGTH_SHORT)
        (context as AppCompatActivity).runOnUiThread {
            t.show()
        }
        msgToasts.add(t)
    }

    /**
     * 移除所有Toast訊息
     */
    fun killAllMessage() {
        for (t in msgToasts) t.cancel()
        msgToasts.clear()
    }
}
