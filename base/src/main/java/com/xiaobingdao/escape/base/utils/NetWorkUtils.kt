package com.xiaobingdao.escape.base.utils

import android.content.Context
import android.net.ConnectivityManager

/**
 * Created by hs.ren
 */
class NetWorkUtils {

    companion object {
        fun isNetworkAvailable(context: Context): Boolean {
            val manager = context.applicationContext.getSystemService(
                    Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val info = manager.activeNetworkInfo
            return !(null == info || !info.isAvailable)
        }
    }
}