package com.xiaobingdao.escape.architecturecomponent.ui.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.xiaobingdao.escape.architecturecomponent.ui.MvvmDemoRepository

/**
 * Created by hs.ren on 2019/12/26.
 */

class MvvmDemoV3ViewModelFactory(private val context : Context?) : ViewModelProvider.NewInstanceFactory() {

    private val mRepository  = MvvmDemoRepository(context)
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) =
            MvvmDemoV3ViewModel(mRepository) as T
}