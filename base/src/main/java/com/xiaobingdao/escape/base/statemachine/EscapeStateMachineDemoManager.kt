package com.xiaobingdao.escape.base.statemachine

import android.os.Looper
import android.os.Message
import android.util.Log

class EscapeStateMachineDemoManager private constructor() {
    // TODO clean code for kotlin
    private val mStateHandler: EscapeDemoStateHandler
    private val mIdleState = IdleState()
    private val mRegState = RegState()
    private val mCallState = CallState()
    private val mDestroyState = DestroyState()
    private val mCancelState = CancelState()

    companion object {
        private val TAG = EscapeStateMachineDemoManager::class.java.simpleName
        private var sInstance: EscapeStateMachineDemoManager? = null
        // All instance methods should be called on main thread.
        val instance: EscapeStateMachineDemoManager?
            get() { // All instance methods should be called on main thread.
                throwIfNotOnMainThread()
                if (sInstance == null) {
                    sInstance = EscapeStateMachineDemoManager()
                }
                return sInstance
            }

        private fun throwIfNotOnMainThread() {
            check(Looper.myLooper() == Looper.getMainLooper()) { "SalesStateMachineDemoManager should be accessed on main thread." }
        }
    }

    init {
        mStateHandler = EscapeDemoStateHandler(Looper.getMainLooper(), TAG)
    }

    fun setInitState() {
        mStateHandler.setInitialState(mIdleState)
    }

    fun startService() {
        val msg: Message = mStateHandler.obtainMessage()
        msg.what = 0
        mStateHandler.sendMessage(msg)
    }

    inner class IdleState : HandlerState("IdleState") {
        override fun enter(current: Message?) {
            super.enter(current)
        }

        override fun processMessage(current: Message) {
            super.processMessage(current)
            if (current.what == 0) {
                mStateHandler.transTo(mRegState)
                val msg: Message = mStateHandler.obtainMessage()
                msg.what = 1
                mStateHandler.sendMessage(msg)
            }
        }

        override fun exit(current: Message?) {
            super.exit(current)
        }
    }

    inner class RegState : HandlerState("RegState") {
        override fun enter(current: Message?) {
            super.enter(current)
        }

        override fun processMessage(current: Message?) {
            super.processMessage(current)
            mStateHandler.transTo(mCallState)
            val msg: Message = mStateHandler.obtainMessage()
            msg.what = 2
            mStateHandler.sendMessage(msg)
        }

        override fun exit(current: Message?) {
            super.exit(current)
        }
    }

    inner class CallState : HandlerState("CallState") {
        override fun enter(current: Message?) {
            super.enter(current)
        }

        override fun processMessage(current: Message?) {
            super.processMessage(current)
            mStateHandler.transTo(mDestroyState)
            val msg: Message = mStateHandler.obtainMessage()
            msg.what = 3
            mStateHandler.sendMessage(msg)
        }

        override fun exit(current: Message?) {
            super.exit(current)
        }
    }

    inner class DestroyState : HandlerState("DestroyState") {
        override fun enter(current: Message) {
            super.enter(current)
            if (current.what == 3) {
                try {
                    Thread.sleep(20000)
                    Log.d(TAG, "StateHandler---------thread-------------------------------------------")
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
                val msg: Message = mStateHandler.obtainMessage()
                msg.what = 100
                mStateHandler.sendMessage(msg)
            }
        }

        override fun processMessage(current: Message) {
            super.processMessage(current)
            if (current.what == 0) {
                mStateHandler.transTo(mIdleState)
                mStateHandler.deferMessage(current)
                return
            }
            mStateHandler.transTo(mIdleState)
        }

        override fun exit(current: Message?) {
            super.exit(current)
        }
    }

    inner class CancelState : HandlerState("CancelState") {
        override fun enter(current: Message?) {
            super.enter(current)
        }

        override fun processMessage(current: Message?) {
            super.processMessage(current)
        }

        override fun exit(current: Message?) {
            super.exit(current)
        }
    }

}
