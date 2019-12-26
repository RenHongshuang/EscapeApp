package com.xiaobingdao.escape.myownexperience.ui.menu

import android.content.Context
import android.content.Intent
import com.xiaobingdao.escape.base.uiframe.common.interfaces.EscapeAppMenuListInterface
import com.xiaobingdao.escape.myownexperience.R
import com.xiaobingdao.escape.myownexperience.ui.activity.EscapeAppCorourtineDemoActivity
import com.xiaobingdao.escape.myownexperience.ui.activity.EscapeAppStateMachineDemoActivity

class MyOwnExperienceMenuList : EscapeAppMenuListInterface() {
    override fun getMenuList(caller: Caller): MutableList<String> {
        val menuList = mutableListOf<String>()

        when (caller) {
            Caller.MY_OWN_EXPERIENCE -> {
                menuList.add(STATE_MACHINE)
                menuList.add(COROUTINE)
            }
        }

        return menuList
    }

    override fun getMenuTitleResourceId(menu: String, caller: Caller): Int {
        when (caller) {
            Caller.MY_OWN_EXPERIENCE -> {
                when (menu) {
                    STATE_MACHINE -> return R.string.state_machine
                    COROUTINE -> return R.string.coroutine
                }
            }
        }

        return 0
    }

    override fun getMenuIconResourceId(menu: String, caller: Caller): Int {
        when (caller) {
            Caller.MY_OWN_EXPERIENCE -> {
                when (menu) {
                    STATE_MACHINE -> return R.drawable.ic_sm
                    COROUTINE -> return R.drawable.ic_coroutine
                }
            }
        }

        return 0
    }

    override fun onMenuPressed(menu: String, context: Context, caller: Caller): Intent {
        var intent: Intent = Intent()
        when (caller) {
            Caller.MY_OWN_EXPERIENCE -> {
                when (menu) {
                    STATE_MACHINE -> {
                        intent = Intent(context, EscapeAppStateMachineDemoActivity::class.java)
                    }
                    COROUTINE -> {
                        intent = Intent(context, EscapeAppCorourtineDemoActivity::class.java)
                    }
                }
            }
        }

        return intent
    }
}