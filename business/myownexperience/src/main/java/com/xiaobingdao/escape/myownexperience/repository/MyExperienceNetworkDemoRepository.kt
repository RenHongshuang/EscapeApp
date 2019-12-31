package com.xiaobingdao.escape.myownexperience.repository

import com.xiaobingdao.escape.base.model.NetworkResult
import com.xiaobingdao.escape.base.repository.BaseRepository
import com.xiaobingdao.escape.myownexperience.model.ImageDataResponseBody
import com.xiaobingdao.escape.myownexperience.network.MyExperienceRetrofitClient

/**
 * Created by hs.ren on 2019/12/31.
 */

class MyExperienceNetworkDemoRepository() :BaseRepository() {
    suspend fun getImageData() :NetworkResult<ImageDataResponseBody> {
       return safeApiCall({executeResponse(MyExperienceRetrofitClient.service.getImage())},"")
    }
}