package com.ncku.hospitalhelper.ui

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.ncku.hospitalhelper.R
import kotlinx.android.synthetic.main.activity_web.*

/**
 * Created by Kevin on 2020/6/21.
 */

class ScheduleActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)
    }
}
