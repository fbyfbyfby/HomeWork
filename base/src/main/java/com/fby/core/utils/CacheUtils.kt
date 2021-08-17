package com.fby.core.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.fby.base.R
import com.fby.core.BaseApplication

/**

 * 作者：YS010051USR on 2021/8/17 14:40

 * 邮箱：fengboyang0412@gmail.com

 */
object CacheUtils {
    @SuppressLint("StaticFieldLeak")
    val context = BaseApplication.currentApplication
    private val sp: SharedPreferences = context.getSharedPreferences(
        context.getString(R.string.app_name),
        Context.MODE_PRIVATE
    )

    fun save(key: String, value: String) = sp.edit().putString(key, value).apply()
    fun get(key: String): String? = sp.getString(key, null)
}