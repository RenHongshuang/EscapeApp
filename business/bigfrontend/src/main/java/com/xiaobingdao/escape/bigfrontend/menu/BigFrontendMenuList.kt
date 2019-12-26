package com.xiaobingdao.escape.bigfrontend.menu

import android.content.Context
import android.content.Intent
import com.xiaobingdao.escape.base.uiframe.common.interfaces.EscapeAppMenuListInterface
import com.xiaobingdao.escape.bigfrontend.R
import com.xiaobingdao.escape.bigfrontend.activity.BigFrontendActivity

/**
 * Created by hs.ren on 2019/12/26.
 */

class BigFrontendMenuList : EscapeAppMenuListInterface() {
    override fun getMenuList(caller: Caller): MutableList<String> {
        val menuList = mutableListOf<String>()

        when (caller) {
            Caller.BIG_FRONTEND -> {
                menuList.add(FLUTTER)
            }
        }

        return menuList
    }

    override fun getMenuTitleResourceId(menu: String, caller: Caller): Int {
        when (caller) {
            Caller.BIG_FRONTEND -> {
                when (menu) {
                    FLUTTER -> return R.string.flutter
                }
            }
        }

        return 0
    }

    override fun getMenuIconResourceId(menu: String, caller: Caller): Int {
        when (caller) {
            Caller.BIG_FRONTEND -> {
                when (menu) {
                    FLUTTER -> return R.drawable.ic_flutter
                }
            }
        }

        return 0
    }

    override fun onMenuPressed(menu: String, context: Context, caller: Caller): Intent {
        var intent: Intent = Intent()
        when (caller) {
            Caller.BIG_FRONTEND -> {
                when (menu) {
                    FLUTTER -> {
                        intent = Intent(context, BigFrontendActivity::class.java)
                    }
                }
            }
        }

        return intent
    }
}