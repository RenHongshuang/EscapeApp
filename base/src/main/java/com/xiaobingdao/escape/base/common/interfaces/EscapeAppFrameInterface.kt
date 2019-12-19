package com.xiaobingdao.escape.base.uiframe.common.interfaces

import android.content.Context

import com.xiaobingdao.escape.base.common.adapters.EscapeAppFrameLayoutBinder
import com.xiaobingdao.escape.base.common.adapters.EscapeAppFrameLayoutUpdater
import com.xiaobingdao.escape.base.common.model.EscapeAppFrameDomain
import com.xiaobingdao.escape.base.common.model.FrameData
import kotlin.reflect.KClass

/**
 * Created by hs.ren on 2019/11/20.
 */

abstract class EscapeAppFrameInterface(val domain: String, yourFrameClass: KClass<out EscapeAppFrameInterface>) {
    companion object {
        protected var TAG = EscapeAppFrameInterface::class.simpleName
    }

    val pageDomain: String?

    init {
        yourFrameClass.let {
            TAG = it.simpleName + " - " + domain
        }
        this.pageDomain = EscapeAppFrameDomain.getFramePageDomain(domain)
    }

    abstract fun onBindFrameView(context: Context?, frameData: FrameData): EscapeAppFrameLayoutBinder

    abstract fun onUpdateFrameView(frameData: FrameData): EscapeAppFrameLayoutUpdater

    abstract fun onFrameHiddenChanged(isFrameHidden: Boolean)

    abstract fun onUnbindFrameView(isDestroyed: Boolean)

    fun onFrameLayoutClick(viewId: Int): Boolean {
        return false
    }
}