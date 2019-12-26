package com.xiaobingdao.escape.base.uiframe.common.interfaces

import android.content.Context
import android.content.Intent
import java.util.ArrayList

/**
 * Created by hs.ren on 2019/11/21.
 */

abstract class EscapeAppMenuListInterface {

    companion object {
        // my own experience frame
        val STATE_MACHINE = "stateMachine"
        val COROUTINE = "Coroutine"
        // big frontend
        val FLUTTER ="flutter"
        // ARCHITECTURE_COMPONENT
        val MVVM_ARCHITECTURE ="mvvmArchitecture"
        // ui component
        val VIRTURE_VIEW ="virtureView"

    }

    enum class Caller {
        MY_OWN_EXPERIENCE,
        BIG_FRONTEND,
        ARCHITECTURE_COMPONENT,
        UI_COMPONENT
    }

    abstract fun getMenuList(caller: Caller): MutableList<String>

    abstract fun getMenuTitleResourceId(menu: String, caller: Caller): Int

    abstract fun getMenuIconResourceId(menu: String, caller: Caller): Int

    abstract fun onMenuPressed(menu: String, context: Context, caller: Caller): Intent
}