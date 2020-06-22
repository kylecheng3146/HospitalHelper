package com.ncku.hospitalhelper.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.mvvm.utils.SharePrefsUtils
import com.ncku.hospitalhelper.R
import com.ncku.hospitalhelper.utils.CommonUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.button -> {
                val intent = Intent(this, RegisterActivity::class.java)
                // start your next activity
                startActivity(intent)
            }

            R.id.button3 -> {
                if(!SharePrefsUtils.getChartNo(this).isNullOrEmpty()){
                    val intent = Intent(this, WebViewActivity::class.java)
                    // start your next activity
                    startActivity(intent)
                }else{
                    CommonUtils.showMessage(this,"請先註冊個人資訊")
                }
            }

            R.id.button4 -> {
                if(!SharePrefsUtils.getChartNo(this).isNullOrEmpty()) {
                    val intent = Intent(this, PersonalInfoActivity::class.java)
                    // start your next activity
                    startActivity(intent)
                }else{
                    CommonUtils.showMessage(this,"請先註冊個人資訊")
                }
            }

            R.id.button5 -> {
                val intent = Intent(this, PillActivity::class.java)
                // start your next activity
                startActivity(intent)
            }

            R.id.button6 -> {
                val intent = Intent(this, BloodActivity::class.java)
                // start your next activity
                startActivity(intent)
            }
        }
    }
}
