package com.xiaobingdao.escape.base.model

/**
 * Created by hs.ren
 */
data class BaseResponse<out T>(val errorCode: Int, val errorMsg: String, val data: T)