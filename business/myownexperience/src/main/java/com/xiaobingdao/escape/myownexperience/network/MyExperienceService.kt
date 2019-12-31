package luyao.wanandroid.model.api

import com.xiaobingdao.escape.base.model.BaseResponse
import com.xiaobingdao.escape.myownexperience.model.ImageDataResponseBody
import retrofit2.http.*
/**
 * Created by luyao
 * on 2018/3/13 14:33
 */
interface MyExperienceService {

    companion object {
        const val BASE_URL = "https://api.ooopn.com/"
    }
    @GET("image/sogou/api.php")
    suspend fun getImage(@Query("type") type: String = "json"): BaseResponse<ImageDataResponseBody>

}