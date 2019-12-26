package com.hccn.smt.basesmt.viewmodel

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.*

/**
 * Created by hs.ren on 2019/8/14.
 */

abstract class BaseViewModel : ViewModel(), LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    abstract fun onDestroy()
}