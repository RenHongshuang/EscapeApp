package com.xiaobingdao.escape.myownexperience.network

import com.xiaobingdao.escape.base.network.BaseRetrofitClient


/**
 * Created by hs.ren
 */
object MyExperienceRetrofitClient : BaseRetrofitClient() {
    val service by lazy { getService(MyExperienceService::class.java, MyExperienceService.BASE_URL) }
}