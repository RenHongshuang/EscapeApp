package com.xiaobingdao.escape.base.model

/**
 * Created by luyao
 * on 2018/3/13 14:38
 */
data class BaseResponse<out T>(val errorCode: Int, val errorMsg: String, val data: T)