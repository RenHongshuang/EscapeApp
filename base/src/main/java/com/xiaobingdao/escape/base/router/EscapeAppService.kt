package com.xiaobingdao.escape.base.router

import androidx.fragment.app.FragmentActivity
import com.alibaba.android.arouter.facade.template.IProvider

/**
 * Created by hs.ren on 2019/12/31.
 */

interface EscapeAppService : IProvider {
    fun toHomeActivity(fragmentActivity: FragmentActivity)
}