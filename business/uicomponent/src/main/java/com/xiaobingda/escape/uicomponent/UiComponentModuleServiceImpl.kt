package com.xiaobingda.escape.uicomponent

import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.xiaobingdao.escape.base.router.EscapeRouterPath
import com.xiaobingdao.escape.base.router.UiComponentModuleService

/**
 * Created by hs.ren on 2019/12/31.
 */
@Route(path = EscapeRouterPath.UiComponentModuleService)
class UiComponentModuleServiceImpl :UiComponentModuleService {
    override fun init(context: Context?) {
        Log.d("xiaobingdao","xiaobingdao router UiComponentModuleServiceImpl init")
    }
}