package com.xiaobingda.escape.uicomponent.menu

import android.content.Context
import android.content.Intent
import com.xiaobingda.escape.uicomponent.R
import com.xiaobingda.escape.uicomponent.activity.UiComponentActivity
import com.xiaobingdao.escape.base.uiframe.common.interfaces.EscapeAppMenuListInterface

/**
 * Created by hs.ren on 2019/12/26.
 */

class UiComponentMenuList :EscapeAppMenuListInterface() {
    override fun getMenuList(caller: Caller): MutableList<String> {
        val menuList = mutableListOf<String>()

        when (caller) {
            Caller.UI_COMPONENT -> {
                menuList.add(VIRTURE_VIEW)
            }
        }

        return menuList
    }

    override fun getMenuTitleResourceId(menu: String, caller: Caller): Int {
        when (caller) {
            Caller.UI_COMPONENT -> {
                when (menu) {
                    VIRTURE_VIEW-> return R.string.vitural_view
                }
            }
        }

        return 0
    }

    override fun getMenuIconResourceId(menu: String, caller: Caller): Int {
        when (caller) {
            Caller.UI_COMPONENT -> {
                when (menu) {
                    VIRTURE_VIEW -> return R.drawable.ic_vitural_view
                }
            }
        }
        return 0;
    }

    override fun onMenuPressed(menu: String, context: Context, caller: Caller): Intent {
        var intent: Intent = Intent()
        when (caller) {
            Caller.UI_COMPONENT -> {
                when (menu) {
                    VIRTURE_VIEW -> {
                        intent = Intent(context, UiComponentActivity::class.java)
                    }
                }
            }
        }

        return intent
    }
}