package luyao.wanandroid.model.api

import com.xiaobingdao.escape.base.network.BaseRetrofitClient


/**
 * Created by luyao
 * on 2018/3/13 15:45
 */
object MyExperienceRetrofitClient : BaseRetrofitClient() {
    val service by lazy { getService(MyExperienceService::class.java, MyExperienceService.BASE_URL) }
}