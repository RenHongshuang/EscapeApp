package com.xiaobingdao.escape.base.router

import android.content.Context
import com.alibaba.android.arouter.facade.template.IProvider

/**
 * Created by hs.ren on 2019/12/31.
 */

interface ArchitectureComponentModuleService :IProvider  {
    fun initKoin(context : Context)
}