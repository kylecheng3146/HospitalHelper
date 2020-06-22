package com.ncku.hospitalhelper.ui

import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.ncku.hospitalhelper.R
import kotlinx.android.synthetic.main.activity_web.*

/**
 * Created by Kevin on 2020/6/22.
 */

class PersonalInfoActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        web.getSettings().setJavaScriptEnabled(true);
        web.setWebChromeClient(WebChromeClient())
        web.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }
        web.loadUrl("https://service.hosp.ncku.edu.tw/Tandem/QueryResultUI.aspx?Lang=&skv=5P4UVD7cvmMC7mqyoHkLFkcI7%2B%2FCFs1nLpiduujdzlhYrbsyxKARmw%3D%3D")
    }
}
