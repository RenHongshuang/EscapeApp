package com.xiaobingdao.escape.architecturecomponent.ui.menu

import android.content.Context
import android.content.Intent
import com.xiaobingdao.escape.architecturecomponent.R
import com.xiaobingdao.escape.architecturecomponent.ui.activity.MvvmDemoActivity
import com.xiaobingdao.escape.base.uiframe.common.interfaces.EscapeAppMenuListInterface

/**
 * Created by hs.ren on 2019/12/26.
 */

class ArchitectureComponentMenuList :EscapeAppMenuListInterface() {
    override fun getMenuList(caller: Caller): MutableList<String> {
        val menuList = mutableListOf<String>()

        when (caller) {
            Caller.ARCHITECTURE_COMPONENT -> {
                menuList.add(MVVM_ARCHITECTURE)
            }
        }

        return menuList
    }

    override fun getMenuTitleResourceId(menu: String, caller: Caller): Int {
        when (caller) {
            Caller.ARCHITECTURE_COMPONENT -> {
                when (menu) {
                    MVVM_ARCHITECTURE -> return R.string.architecture_mvvm
                }
            }
        }

        return 0
    }

    override fun getMenuIconResourceId(menu: String, caller: Caller): Int {
        when (caller) {
            Caller.ARCHITECTURE_COMPONENT -> {
                when (menu) {
                    MVVM_ARCHITECTURE -> return R.drawable.ic_mvvm
                }
            }
        }

        return 0
    }

    override fun onMenuPressed(menu: String, context: Context, caller: Caller): Intent {
        var intent: Intent = Intent()
        when (caller) {
            Caller.ARCHITECTURE_COMPONENT -> {
                when (menu) {
                    MVVM_ARCHITECTURE -> {
                        intent = Intent(context, MvvmDemoActivity::class.java)
                    }
                }
            }
        }

        return intent
    }
}