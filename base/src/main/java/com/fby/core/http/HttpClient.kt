package com.fby.core.http

import com.google.gson.Gson
import okhttp3.*
import java.io.IOException
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

    fun <T> get(path: String, type: Type, entryCallback: EntityCallback<T>) {
        val request = Request.Builder()
            .url("https://api.hencoder.com/$path")
            .build()
        val call = newCall(request)
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                entryCallback.onFailure("网络异常")
            }

            override fun onResponse(call: Call, response: Response) {
                when (response.code()) {
                    in 200..299 -> {
                        val body = response.body()
                        val json = body?.string()
                        entryCallback.onSucess(convert(json, type))
                    }
                    in 400..499 -> entryCallback.onFailure("客户端错误")
                    in 500..599 -> entryCallback.onFailure("服务器错误")
                    else -> entryCallback.onFailure("未知错误")
                }
            }
        })
    }
}