package com.xiaobingdao.escape.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.xiaobingdao.escape.base.ui.BaseActivity
import com.xiaobingdao.escape.ui.activity.EscapeHomeActivity

class EscapeSplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this, EscapeHomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}