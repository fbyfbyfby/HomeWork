package com.fby.core.http

/**

 * 作者：YS010051USR on 2021/8/25 11:05

 * 邮箱：fengboyang0412@gmail.com

 */
interface EntityCallback<T> {
    fun onSucess(entity: T)
    fun onFailure(message: String)
}