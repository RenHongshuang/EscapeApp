package com.xiaobingdao.escape.ui

import android.content.Context
import androidx.fragment.app.FragmentActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.xiaobingdao.escape.base.router.EscapeAppService
import com.xiaobingdao.escape.base.router.EscapeRouterPath

/**
 * Created by hs.ren on 2019/12/31.
 */
@Route(path = EscapeRouterPath.EscapeAppService)
class EscapeAppServiceImpl : EscapeAppService {
    override fun init(context: Context?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun toHomeActivity(fragmentActivity: FragmentActivity) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}