package com.xiaobingdao.escape.myownexperience.ui.menu

import android.content.Context
import android.content.Intent
import com.xiaobingdao.escape.base.uiframe.common.interfaces.EscapeAppMenuListInterface
import com.xiaobingdao.escape.myownexperience.R
import com.xiaobingdao.escape.myownexperience.ui.activity.EscapeAppStateMachineDemoActivity

class MyOwnExperienceMenuList : EscapeAppMenuListInterface() {
    override fun getMenuList(caller: Caller): MutableList<String> {
        val menuList = mutableListOf<String>()

        when (caller) {
            Caller.MYOWNEXPERIENCE -> {
                menuList.add(STATE_MACHINE)
            }
        }

        return menuList
    }

    override fun getMenuTitleResourceId(menu: String, caller: Caller): Int {
        when (caller) {
            Caller.MYOWNEXPERIENCE -> {
                when (menu) {
                    STATE_MACHINE -> return R.string.app_name
                }
            }
        }

        return 0
    }

    override fun getMenuIconResourceId(menu: String, caller: Caller): Int {
        when (caller) {
            Caller.MYOWNEXPERIENCE -> {
                when (menu) {
                    STATE_MACHINE -> return R.drawable.ic_launcher_foreground
                }
            }
        }

        return 0
    }

    override fun onMenuPressed(menu: String, context: Context, caller: Caller): Intent {
        var intent: Intent = Intent()
        when (caller) {
            Caller.MYOWNEXPERIENCE -> {
                when (menu) {
                    STATE_MACHINE -> {
                        intent = Intent(context, EscapeAppStateMachineDemoActivity::class.java)
                    }
                }
            }
        }

        return intent
    }
}