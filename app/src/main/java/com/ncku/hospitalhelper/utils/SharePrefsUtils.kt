package com.mvvm.utils

import android.content.Context

/**
 * Created by Kyle on 2020-02-10.
 */

object SharePrefsUtils {
    private const val FILE_NAME = "save_data"

    fun putId(context: Context, id: String?) { // 1.產生SharedPreference
        val pref = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
        // 2.取得寫入至 xml 物件
        val edit = pref.edit()
        // 3.寫入資料
        edit.putString("id", id)
        // 4.確認寫入
        edit.apply()
    }

    fun getId(context: Context): String { // 1.產生SharedPreference
        val pref = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
        // 2.讀取資料
        return pref.getString("id", "")!!
    }

    fun putChartNo(context: Context, chart_no: String?) { // 1.產生SharedPreference
        val pref = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
        // 2.取得寫入至 xml 物件
        val edit = pref.edit()
        // 3.寫入資料
        edit.putString("chart_no", chart_no)
        // 4.確認寫入
        edit.apply()
    }

    fun getChartNo(context: Context): String { // 1.產生SharedPreference
        val pref = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
        // 2.讀取資料
        return pref.getString("chart_no", "")!!
    }

    fun putBirthday(context: Context, birth_day: String?) { // 1.產生SharedPreference
        val pref = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
        // 2.取得寫入至 xml 物件
        val edit = pref.edit()
        // 3.寫入資料
        edit.putString("birth_day", birth_day)
        // 4.確認寫入
        edit.apply()
    }

    fun getBirthday(context: Context): String { // 1.產生SharedPreference
        val pref = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
        // 2.讀取資料
        return pref.getString("birth_day", "")!!
    }
}
