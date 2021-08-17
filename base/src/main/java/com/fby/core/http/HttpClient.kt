package com.fby.core.http

import com.google.gson.Gson
import okhttp3.OkHttpClient
import java.lang.reflect.Type

/**

 * 作者：YS010051USR on 2021/8/17 15:30

 * 邮箱：fengboyang0412@gmail.com

 */
object HttpClient : OkHttpClient() {
    private val gson = Gson()
    fun <T> convert(json: String?, type: Type): T {
        return gson.fromJson(json, type)
    }
}