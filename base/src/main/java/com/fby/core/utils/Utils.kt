package com.fby.core.utils

import android.content.res.Resources
import android.util.TypedValue
import android.widget.Toast
import com.fby.core.BaseApplication
import java.time.Duration

/**

 * 作者：YS010051USR on 2021/8/17 14:54

 * 邮箱：fengboyang0412@gmail.com

 */
object Utils {
    private val displayMetrics = Resources.getSystem().displayMetrics
    fun Float.dp2px(): Float {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, displayMetrics)
    }

    fun toast(string: String?) {
        toast(string, Toast.LENGTH_SHORT)
    }

    fun toast(string: String?, duration: Int) =
        Toast.makeText(BaseApplication.currentApplication, string, duration).show()
}