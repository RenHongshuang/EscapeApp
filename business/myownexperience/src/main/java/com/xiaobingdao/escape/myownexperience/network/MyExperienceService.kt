package com.xiaobingdao.escape.myownexperience.network

import com.xiaobingdao.escape.base.model.BaseResponse
import com.xiaobingdao.escape.myownexperience.model.ImageDataResponseBody
import retrofit2.http.*
/**
 * Created by hs.ren
 */
interface MyExperienceService {

    companion object {
        const val BASE_URL = "https://api.ooopn.com/"
    }
    @GET("image/sogou/api.php")
    suspend fun getImage(@Query("type") type: String = "json"): BaseResponse<ImageDataResponseBody>

}