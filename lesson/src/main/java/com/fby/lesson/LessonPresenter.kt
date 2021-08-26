package com.fby.lesson

import com.fby.core.http.EntityCallback
import com.fby.core.http.HttpClient
import com.fby.core.utils.Utils
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

/**

 * 作者：YS010051USR on 2021/8/25 15:08

 * 邮箱：fengboyang0412@gmail.com

 */
class LessonPresenter(var activity: LessonActivity) {
    companion object {
        val LESSON_PATH = "lessons"
    }

    var lessons: ArrayList<Lesson> = ArrayList()
    val type: Type = object : TypeToken<List<Lesson>>() {}.type

    fun fetchData() {
        HttpClient.get(LESSON_PATH, type, object : EntityCallback<ArrayList<Lesson>> {
            override fun onSucess(entity: ArrayList<Lesson>) {
                lessons = entity
                activity.runOnUiThread {
                    activity.showResult(lessons)
                }
            }

            override fun onFailure(message: String) {
                activity.runOnUiThread {
                    Utils.toast(message)
                }
            }
        })
    }

    fun showPlayback() {
        activity.showResult(lessons.filter { it.state == Lesson.State.PLAYBACK } as ArrayList<Lesson>)
    }
}