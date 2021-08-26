package com.fby.lesson

/**

 * 作者：YS010051USR on 2021/8/25 16:33

 * 邮箱：fengboyang0412@gmail.com

 */
class Lesson(var date: String?, var content: String?, var state: State?) {
    enum class State {
        PLAYBACK {
            override fun stateName(): String {
                return "有回放"
            }
        },
        LIVE {
            override fun stateName(): String {
                return "正在直播"
            }
        },
        WAIT {
            override fun stateName(): String {
                return "等待种"
            }
        };

        abstract fun stateName(): String
    }
}