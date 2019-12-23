package com.hccn.smt.basesmt.ui.fragments

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.hccn.smt.basesmt.viewmodel.BaseViewModel
import com.xiaobingdao.escape.base.ui.BaseFragment
import kotlin.reflect.KClass

/**
 * Created by hs.ren on 2019/12/19.
 */

abstract class BaseMvvmFragment<VM : BaseViewModel>(clazz: KClass<VM>) : BaseFragment() {
    protected var mViewModel: VM = ViewModelProviders.of(this).get(clazz.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel.lifecycleOwner?.value = activity
        lifecycle.addObserver(mViewModel)
    }

    override fun onDestroy() {
        lifecycle.removeObserver(mViewModel)
        super.onDestroy()
    }
}