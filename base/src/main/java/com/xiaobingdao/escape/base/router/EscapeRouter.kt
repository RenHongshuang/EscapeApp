package com.xiaobingdao.escape.base.router

import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.launcher.ARouter

/**
 * Created by hs.ren on 2019/12/31.
 */

object EscapeRouter {
    /**
     * Get instance of router. A
     * All feature U use, will be starts here.
     */
    private val instance: ARouter = ARouter.getInstance()


    /**
     * Build the road map, draw a postcard.
     *
     * @param path Where you go.
     */
    fun build(path: String): Postcard {
        return instance.build(path)
    }

    /**
     * Navigation to the route with path in postcard.
     * No param, will be use application context.
     */
    fun navigation(path: String) {
        build(path).navigation()
    }

    /**
     * Launch the navigation by type
     *
     * @param service interface of service
     * @param <T>     return type
     * @return instance of service
     */
    private fun <T> getService(service: Class<T>): T {
        return instance.navigation(service)
    }
}