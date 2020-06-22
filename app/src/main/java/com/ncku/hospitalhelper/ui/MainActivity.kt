package com.ncku.hospitalhelper.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ncku.hospitalhelper.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button3.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.button3 -> {
                val intent = Intent(this, WebViewActivity::class.java)
                // start your next activity
                startActivity(intent)
            }

            R.id.button4 -> {
                val intent = Intent(this, ScheduleActivity::class.java)
                // start your next activity
                startActivity(intent)
            }
        }
    }
}
