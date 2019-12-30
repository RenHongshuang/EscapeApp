package com.xiaobingdao.escape.ui

import android.app.Application
import android.content.Context
import com.xiaobingdao.escape.base.utils.EscapeUtils
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import kotlin.properties.Delegates

/**
 * Created by hs.ren on 2019/12/26.
 */

class EscapeApplication :Application() {
    override fun onCreate() {
        EscapeUtils.applicationContext = applicationContext
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