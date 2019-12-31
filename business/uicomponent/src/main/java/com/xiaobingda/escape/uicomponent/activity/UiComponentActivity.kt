package com.xiaobingda.escape.uicomponent.activity

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.xiaobingda.escape.uicomponent.R
import com.xiaobingdao.escape.base.router.EscapeRouterPath
import com.xiaobingdao.escape.base.ui.BaseActivity

@Route(path = EscapeRouterPath.UiComponentActivity)
class UiComponentActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ui_component)
    }
}
