package com.hccn.smt.basesmt.viewmodel

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.*

/**
 * Created by hs.ren on 2019/8/14.
 */

open class BaseViewModel : ViewModel(), LifecycleObserver {
    var lifecycleOwner: MutableLiveData<FragmentActivity?>? = MutableLiveData()

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        lifecycleOwner?.value = null
    }
}