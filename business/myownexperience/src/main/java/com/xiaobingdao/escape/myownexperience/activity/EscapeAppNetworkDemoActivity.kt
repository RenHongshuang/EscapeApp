package com.xiaobingdao.escape.myownexperience.activity

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.alibaba.android.arouter.facade.annotation.Route
import com.xiaobingdao.escape.base.router.EscapeRouterPath
import com.xiaobingdao.escape.base.ui.BaseActivity
import com.xiaobingdao.escape.myownexperience.R
import com.xiaobingdao.escape.myownexperience.viewmodel.EscapeNetworkActivityViewModel
/**
 * Created by hs.ren on 2019/12/23.
 */

@Route(path = EscapeRouterPath.EscapeAppNetworkDemoActivity)
@Suppress("NAME_SHADOWING")
class EscapeAppNetworkDemoActivity :BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cotourine_demo_layout)
        val mViewModel = ViewModelProviders.of(this).get(EscapeNetworkActivityViewModel::class.java)
        lifecycle.addObserver(mViewModel)
        //mViewModel.getData()
        mViewModel.getImageData()
    }
}