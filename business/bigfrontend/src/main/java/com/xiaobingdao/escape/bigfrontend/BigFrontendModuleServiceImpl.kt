package com.xiaobingdao.escape.bigfrontend

import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.xiaobingdao.escape.base.router.BigFrontendModuleService
import com.xiaobingdao.escape.base.router.EscapeRouterPath

/**
 * Created by hs.ren on 2019/12/31.
 */
@Route(path = EscapeRouterPath.BigFrontendModuleService)
class BigFrontendModuleServiceImpl : BigFrontendModuleService {
    override fun init(context: Context?) {
        Log.d("xiaobingdao","xiaobingdao router BigFrontendModuleServiceImpl init")
    }
}