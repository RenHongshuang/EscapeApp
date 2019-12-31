package com.xiaobingdao.escape.myownexperience.activity

import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.xiaobingdao.escape.base.router.EscapeRouterPath
import com.xiaobingdao.escape.base.ui.BaseActivity
import com.xiaobingdao.escape.base.statemachine.EscapeStateMachineDemoManager
import com.xiaobingdao.escape.myownexperience.R
import kotlinx.android.synthetic.main.activity_sm_demo_layout.*

@Route(path = EscapeRouterPath.EscapeAppStateMachineDemoActivity)
class EscapeAppStateMachineDemoActivity : BaseActivity() {

    private val TAG: String = EscapeAppStateMachineDemoActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sm_demo_layout)
        EscapeStateMachineDemoManager.instance?.setInitState()
        button.setOnClickListener(View.OnClickListener { EscapeStateMachineDemoManager.instance?.startService() })
    }

}