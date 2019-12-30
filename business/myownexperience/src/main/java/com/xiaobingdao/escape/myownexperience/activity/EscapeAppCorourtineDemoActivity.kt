package com.xiaobingdao.escape.myownexperience.activity

import android.os.Bundle
import android.util.Log
import com.xiaobingdao.escape.base.ui.BaseActivity
import com.xiaobingdao.escape.myownexperience.R
import kotlinx.coroutines.*

/**
 * Created by hs.ren on 2019/12/23.
 */

@Suppress("NAME_SHADOWING")
class EscapeAppCorourtineDemoActivity :BaseActivity() {


    // set Coroutine Scope by your-self
    val viewModelJob = Job()
    val ioScope = CoroutineScope(Dispatchers.IO + viewModelJob)

    // set visorCoroutine Scope by your-self
    val visorScope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cotourine_demo_layout)
        testGlobalCoroutine()
    }

    override fun onDestroy() {
        // 在activity 中可以使用MainScope 或者其他自定义Scope， 需要在onDestroy()中cancel.
        MainScope().cancel()
        ioScope.cancel()
        visorScope.cancel()
        super.onDestroy()
    }

    // 协程应该用结构化并发的方式使用，在android 应该尽可能的用ViewModelScope
    fun testGlobalCoroutine() {
        GlobalScope.launch {
            Log.d("xiaobingdao", "Global scope 0 coroutine test start" + Thread.currentThread().name)
            delay(3000)
            Log.d("xiaobingdao", "Global scope 0 coroutine test end" + Thread.currentThread().name)
        }

        GlobalScope.launch(Dispatchers.Unconfined) {
            Log.d("xiaobingdao", "Global scope 1 coroutine test start " + Thread.currentThread().name)
            delay(3000)
            Log.d("xiaobingdao", "Global scope 1 coroutine test end " + Thread.currentThread().name)
        }

        GlobalScope.launch(Dispatchers.Main) {
            Log.d("xiaobingdao", "Global scope 2 coroutine test start " + Thread.currentThread().name)
            delay(3000)
            Log.d("xiaobingdao", "Global scope 2 coroutine test end " + Thread.currentThread().name)
        }

        val job1  = GlobalScope.launch(Dispatchers.IO,start = CoroutineStart.LAZY) {
            Log.d("xiaobingdao", "Global scope 3 coroutine test start " + Thread.currentThread().name)
            delay(3000)
            Log.d("xiaobingdao", "Global scope  3 coroutine test end " + Thread.currentThread().name)
        }
        job1.start()

        // async 不会阻塞线程
        val deferred = GlobalScope.async {
            delay(1000L)
            Log.d("xiaobingdao", "xiaobingdao This is async ")
            return@async "xiaobingdao"
        }
        Log.d("xiaobingdao", "xiaobingdao async main end ")
        // async 会阻塞当前协程
        GlobalScope.launch(Dispatchers.IO) {
            val deferred = GlobalScope.async {
                delay(3000L)
                Log.d("xiaobingdao", "xiaobingdao This is async ")
                return@async "xiaobingdao"
            }
            Log.d("xiaobingdao", "xiaobingdao 协程 IO start")
            val result = deferred.await()
            Log.d("xiaobingdao", "xiaobingdao async result is $result")
            Log.d("xiaobingdao", "xiaobingdao  IO end ")
        }

        // withContext
        GlobalScope.launch(Dispatchers.IO) {
            Log.d("xiaobingdao", "xiaobingdao Global scope IO coroutine test start " + Thread.currentThread().name)
            withContext(Dispatchers.Main) {
                delay(100)
                Log.d("xiaobingdao", "xiaobingdao with Context Main coroutine test start " + Thread.currentThread().name)
            }
        }

        // MainScope
        MainScope().launch {
            Log.d("xiaobingdao", "xiaobingdao Main scope IO coroutine test start " + Thread.currentThread().name)
        }

        // 自定义Scope
        ioScope.launch {
            Log.d("xiaobingdao", "xiaobingdao  IOscope IO coroutine test start " + Thread.currentThread().name)
        }
        visorScope.launch {
            Log.d("xiaobingdao", "xiaobingdao  visorScope IO coroutine test start " + Thread.currentThread().name)
        }


         //coroutineScope 和 supervisorScope,用于协程中启动多个协程，当父scope cancel的时候 子协程也会被取消，避免泄漏
        val job = GlobalScope.launch {
            coroutineScope {
                var i:Int  = 0
                repeat(1000) {
                    launch {
                        Log.d("xiaobingdao", "xiaobingdao  coroutineScope launch test start " + Thread.currentThread().name + " " + i)
                    }
                    Log.d("xiaobingdao", "xiaobingdao  repeat launch test start " + Thread.currentThread().name)
                    i++
                    if(i == 20){
                        cancel()
                    }
                }
            }
        }
        GlobalScope.launch(Dispatchers.Main){
            job.cancel()
//            job.start()
//            job.join()
//            job.cancelAndJoin()
        }


        GlobalScope.launch(Dispatchers.Main){
            Log.d("xiaobingdao", "xiaobingdao  supervisorScope async test start " + Thread.currentThread().name)
            val deferred1  = supervisorScope {
                async {
                    delay(3000)
                    Log.d("xiaobingdao", "xiaobingdao  supervisorScope async1 test start " + Thread.currentThread().name)
                }
            }
            val deferred11 = supervisorScope {
                async {
                    delay(4000)
                    Log.d("xiaobingdao", "xiaobingdao  supervisorScope async2 test start " + Thread.currentThread().name)
                }
            }
            val result1 = deferred1.await()
            val result2 = deferred1.await()
            Log.d("xiaobingdao", "xiaobingdao  supervisorScope async test start deferred $result1+$result2" + Thread.currentThread().name)
        }
    }
}