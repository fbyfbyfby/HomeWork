package com.fby.core

import android.view.View
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView

/**

 * 作者：YS010051USR on 2021/8/17 14:07

 * 邮箱：fengboyang0412@gmail.com

 */
abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val viewHashmap = HashMap<Int, View>()
    protected fun <T : View> getView(@IdRes id: Int): T {
        var view = viewHashmap[id]
        if (view == null) {
            view = itemView.findViewById(id);
            viewHashmap[id] = view
        }
        return view as T
    }

    protected fun setText(id: Int, text: String?) {
        getView<TextView>(id).text = text
    }
}