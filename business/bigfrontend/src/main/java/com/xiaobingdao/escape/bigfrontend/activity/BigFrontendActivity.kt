package com.xiaobingdao.escape.bigfrontend.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.xiaobingdao.escape.base.router.EscapeRouterPath
import com.xiaobingdao.escape.bigfrontend.R

@Route(path = EscapeRouterPath.BigFrontendActivity)
class BigFrontendActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_big_frontend)
    }
}
