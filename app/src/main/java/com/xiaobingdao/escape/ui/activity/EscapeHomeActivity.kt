package com.xiaobingdao.escape.ui.activity

import android.os.Bundle
import android.view.MenuItem
import com.alibaba.android.arouter.facade.annotation.Route
import com.google.android.material.bottomnavigation.BottomNavigationView

import com.xiaobingdao.escape.R
import com.xiaobingdao.escape.base.router.EscapeRouter
import com.xiaobingdao.escape.base.router.EscapeRouterPath
import com.xiaobingdao.escape.base.ui.BaseActivity
import com.xiaobingdao.escape.ui.fragment.EscapeAppHomeFragment
import kotlinx.android.synthetic.main.activity_escape_home.*

@Route(path = EscapeRouterPath.EscapeHomeActivity)
class EscapeHomeActivity : BaseActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_escape_home)
        bottom_navigation.setOnNavigationItemSelectedListener(this)
        bottom_navigation.selectedItemId = R.id.action_main
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_main -> showHomeFragment()
            R.id.action_me -> ArouterFunticonTest()
        }
        return true
    }

    private fun showHomeFragment() {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.container, EscapeAppHomeFragment.newInstance())
        ft.commitAllowingStateLoss()
    }

    private fun ArouterFunticonTest(){
        EscapeRouter.navigation(EscapeRouterPath.MvvmDemoActivity)
    }
}
