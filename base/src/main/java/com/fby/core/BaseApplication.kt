package com.fby.core

import android.app.Application
import android.content.Context

/**

 * 作者：YS010051USR on 2021/8/17 14:29

 * 邮箱：fengboyang0412@gmail.com

 */
class BaseApplication : Application() {
    companion object {
        lateinit var currentApplication: Context
            private set
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        currentApplication = this
    }
}