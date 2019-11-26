package com.xiaobingdao.escape.base.ui

import android.app.Activity
import android.os.Bundle
import com.xiaobingdao.escape.base.R

class BaseActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }
}
