package com.xiaobingdao.escape.bigfrontend.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.xiaobingdao.escape.base.router.EscapeRouterPath
import io.flutter.embedding.android.FlutterActivity

@Route(path = EscapeRouterPath.BigFrontendActivity)
class BigFrontendActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(FlutterActivity.createDefaultIntent(this))
    }
}
