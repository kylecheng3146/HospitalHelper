package com.ncku.hospitalhelper.ui

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.mvvm.utils.SharePrefsUtils
import com.ncku.hospitalhelper.R
import com.ncku.hospitalhelper.utils.CommonUtils
import kotlinx.android.synthetic.main.activity_register.*
import java.text.SimpleDateFormat
import java.util.*
import javax.xml.datatype.DatatypeConstants.MONTHS

/**
 * Created by Kevin on 2020/6/22.
 */


class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    var thisAMonth = 0
    var thisADay = 0
    var thisAYear = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var cal = Calendar.getInstance()

        val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val myFormat = "yyyy-MM-dd" // mention the format you need
            val sdf = SimpleDateFormat(myFormat, Locale.TAIWAN)
            et_birthday.setText(sdf.format(cal.time))

        }

        et_birthday.setOnClickListener {
            DatePickerDialog(this, dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)).show()
        }

        btn_confrim.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.btn_confrim -> {
                SharePrefsUtils.putId(this,et_identifier.text.toString())
                SharePrefsUtils.putChartNo(this,et_number.text.toString())
                SharePrefsUtils.putBirthday(this,et_birthday.text.toString())
                CommonUtils.showMessage(this,"註冊個人資訊成功")
                this.finish()
            }
        }
    }
}
