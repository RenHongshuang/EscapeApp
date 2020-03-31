package com.xiaobingdao.escape.ui

import android.app.Application
import android.content.res.Configuration
import com.alibaba.android.arouter.launcher.ARouter
import com.xiaobingdao.escape.BuildConfig
import com.xiaobingdao.escape.base.router.EscapeRouter
import com.xiaobingdao.escape.base.utils.EscapeUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Created by hs.ren on 2019/12/26.
 */
class EscapeApplication :Application() {
    override fun onCreate() {
        super.onCreate()
        EscapeUtils.applicationContext = applicationContext
        initArouter()
        initKoin()
        GlobalScope.launch(Dispatchers.Main) {
            delay(1000L)

        }
    }


    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    override fun onTerminate() {
        super.onTerminate()
        ARouter.getInstance().destroy()
    }

    private fun initArouter(){
            // These two lines must be written before init, otherwise these configurations will be invalid in the init process
            if (BuildConfig.DEBUG) {
                // Print log
                ARouter.openLog()
                // Turn on debugging mode (If you are running in InstantRun mode, you must turn on debug mode! Online version needs to be closed, otherwise there is a security risk)
                ARouter.openDebug()
            }
            // As early as possible, it is recommended to initialize in the Application
            ARouter.init(this)
    }
    private fun initKoin() {
        EscapeRouter.ArchitectureComponentModuleService.initKoin(this)
    }
}