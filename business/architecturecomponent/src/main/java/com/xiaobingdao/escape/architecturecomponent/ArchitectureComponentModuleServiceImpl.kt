package com.xiaobingdao.escape.architecturecomponent

import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.xiaobingdao.escape.architecturecomponent.di.viewModelModule
import com.xiaobingdao.escape.base.router.ArchitectureComponentModuleService
import com.xiaobingdao.escape.base.router.EscapeRouter
import com.xiaobingdao.escape.base.router.EscapeRouterPath
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/**
 * Created by hs.ren on 2019/12/31.
 */
@Route(path = EscapeRouterPath.ArchitectureComponentModuleService)
class ArchitectureComponentModuleServiceImpl :ArchitectureComponentModuleService {
    override fun init(context: Context?) {
        Log.d("xiaobingdao","xiaobingdao router ArchitectureComponentModuleService init")
    }
    override fun initKoin(context :Context) {
        startKoin {
            printLogger(Level.DEBUG)
            androidLogger()
            androidContext(context)
            androidFileProperties()
            modules(listOf(viewModelModule))
        }
    }
}