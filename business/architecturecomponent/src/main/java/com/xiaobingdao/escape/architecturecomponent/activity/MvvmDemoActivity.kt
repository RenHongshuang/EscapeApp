package com.xiaobingdao.escape.architecturecomponent.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.xiaobingdao.escape.architecturecomponent.R
import com.xiaobingdao.escape.architecturecomponent.fragment.MvvmDemoV2Fragment
import com.xiaobingdao.escape.base.router.EscapeRouterPath

@Route(path = EscapeRouterPath.MvvmDemoActivity)
class MvvmDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm_demo)
        //supportFragmentManager.beginTransaction().replace(R.id.container, MvvmDemoV1Fragment()).commit()
        supportFragmentManager.beginTransaction().replace(R.id.container, MvvmDemoV2Fragment()).commit()
        //supportFragmentManager.beginTransaction().replace(R.id.container, MvvmDemoV3Fragment()).commit()
        //supportFragmentManager.beginTransaction().replace(R.id.container, MvvmDemoV4Fragment()).commit()
        //supportFragmentManager.beginTransaction().replace(R.id.container, MvvmDemoV5Fragment()).commit()
    }
}
