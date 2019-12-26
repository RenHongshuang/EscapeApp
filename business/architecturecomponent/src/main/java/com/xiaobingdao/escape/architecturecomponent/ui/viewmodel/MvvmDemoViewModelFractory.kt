package com.xiaobingdao.escape.architecturecomponent.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.xiaobingdao.escape.architecturecomponent.ui.MvvmDemoV3Repository
import com.xiaobingdao.escape.base.ui.BaseFragment

/**
 * Created by hs.ren on 2019/12/26.
 */

class MvvmDemoViewModelFractory(private val fragment :BaseFragment) : ViewModelProvider.NewInstanceFactory() {

    private val mRepository : MvvmDemoV3Repository = MvvmDemoV3Repository()
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) =
            MvvmDemoV3ViewModel(mRepository) as T
}