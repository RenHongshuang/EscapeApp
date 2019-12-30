package com.xiaobingdao.escape.myownexperience.ui.activity

import android.os.Bundle
import android.util.Log
import com.xiaobingdao.escape.base.ui.BaseActivity
import com.xiaobingdao.escape.myownexperience.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Created by hs.ren on 2019/12/23.
 */

class EscapeAppCorourtineDemoActivity :BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cotourine_demo_layout)
        testGlobalcorourtine()
    }


    fun testGlobalcorourtine(){
        GlobalScope.launch {
            Log.d("xiaobingdao","Global scope 0 coroutine test start"+ Thread.currentThread().name)
            delay(3000)
            Log.d("xiaobingdao","Global scope 0 coroutine test end" + Thread.currentThread().name)
        }

        GlobalScope.launch(Dispatchers.Unconfined) {
            Log.d("xiaobingdao","Global scope 1 coroutine test start "+ Thread.currentThread().name)
            delay(3000)
            Log.d("xiaobingdao","Global scope 1 coroutine test end " + Thread.currentThread().name)
        }

        GlobalScope.launch(Dispatchers.Main) {
            Log.d("xiaobingdao","Global scope 2 coroutine test start "+ Thread.currentThread().name)
            delay(3000)
            Log.d("xiaobingdao","Global scope 2 coroutine test end " + Thread.currentThread().name)
        }

        GlobalScope.launch(Dispatchers.IO) {
            Log.d("xiaobingdao","Global scope 3 coroutine test start "+ Thread.currentThread().name)
            delay(3000)
            Log.d("xiaobingdao","Global scope  3 coroutine test end " + Thread.currentThread().name)
        }
    }
}