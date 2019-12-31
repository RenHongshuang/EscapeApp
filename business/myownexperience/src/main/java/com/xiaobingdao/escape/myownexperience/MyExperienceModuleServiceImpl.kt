package com.xiaobingdao.escape.myownexperience

import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.xiaobingdao.escape.base.router.EscapeRouterPath
import com.xiaobingdao.escape.base.router.MyExperienceModuleService

/**
 * Created by hs.ren on 2019/12/31.
 */
@Route(path = EscapeRouterPath.MyExperienceModuleService)
class MyExperienceModuleServiceImpl :MyExperienceModuleService {
    override fun init(context: Context?) {
        Log.d("xiaobingdao","xiaobingdao router MyExperienceModuleServiceImpl init")
    }
}