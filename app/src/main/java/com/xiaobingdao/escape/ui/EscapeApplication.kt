package com.xiaobingdao.escape.ui

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.xiaobingdao.escape.BuildConfig
import com.xiaobingdao.escape.base.utils.EscapeUtils
import com.xiaobingdao.escape.ui.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/**
 * Created by hs.ren on 2019/12/26.
 */

class EscapeApplication :Application() {
    override fun onCreate() {
        EscapeUtils.applicationContext = applicationContext
        initKoin()
        initArouter()
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
        startKoin {
            printLogger(Level.DEBUG)
            androidLogger()
            androidContext(this@EscapeApplication)
            androidFileProperties()
            modules(listOf(viewModelModule))
        }
    }
}