package com.fby.lesson

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.recyclerview.widget.RecyclerView
import com.fby.core.BaseView
import com.fby.core.BaseViewHolder

/**

 * 作者：YS010051USR on 2021/8/26 19:51

 * 邮箱：fengboyang0412@gmail.com

 */
class LessonAdapter : RecyclerView.Adapter<LessonAdapter.LessonViewHolder>() {
    var list: ArrayList<Lesson> = ArrayList()

    fun updateAndNotify(list: ArrayList<Lesson>) {
        this.list = list
        notifyDataSetChanged()
    }

    class LessonViewHolder(itemView: View) : BaseViewHolder(itemView) {
        companion object {
            fun onCreate(parent: ViewGroup): LessonViewHolder {
                return LessonViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.item_lesson, parent, false)
                )
            }
        }

        internal fun onBind(lesson: Lesson) {
            setText(R.id.tv_date, lesson.date ?: "日期待定")
            setText(R.id.tv_content, lesson.content ?: "")
            lesson.state?.also {
                setText(R.id.tv_state, it.stateName())
                val colorRes = when (it) {
                    Lesson.State.PLAYBACK -> R.color.playback
                    Lesson.State.LIVE -> R.color.live
                    Lesson.State.WAIT -> R.color.wait
                }
                val backgroundColor = itemView.context.getColor(colorRes)
                getView<TextView>(R.id.tv_state).setBackgroundColor(backgroundColor)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        return LessonViewHolder.onCreate(parent)
    }

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}