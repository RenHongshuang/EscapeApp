package com.xiaobingdao.escape.ui

import android.app.Application
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
        initKoin()
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