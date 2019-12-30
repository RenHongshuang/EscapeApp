package com.xiaobingdao.escape.myownexperience.activity

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.xiaobingdao.escape.base.ui.BaseActivity
import com.xiaobingdao.escape.myownexperience.R
import com.xiaobingdao.escape.myownexperience.viewmodel.EscapeNetworkActivityViewModel
import kotlinx.coroutines.*
import luyao.wanandroid.model.api.MyExperienceRetrofitClient

/**
 * Created by hs.ren on 2019/12/23.
 */

@Suppress("NAME_SHADOWING")
class EscapeAppNetworkDemoActivity :BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cotourine_demo_layout)
        val mViewModel = ViewModelProviders.of(this).get(EscapeNetworkActivityViewModel::class.java)
        lifecycle.addObserver(mViewModel)
        mViewModel.getData()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}