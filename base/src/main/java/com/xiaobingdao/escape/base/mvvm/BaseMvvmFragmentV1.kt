package com.hccn.smt.basesmt.ui.fragments

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.hccn.smt.basesmt.viewmodel.BaseViewModel
import com.xiaobingdao.escape.base.ui.BaseFragment
import kotlin.reflect.KClass

/**
 * Created by hs.ren on 2019/12/19.
 */

abstract class BaseMvvmFragmentV1<VM : BaseViewModel>(val clazz: KClass<VM>) : BaseFragment() {
    lateinit var mViewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProviders.of(this).get(clazz.java)
        lifecycle.addObserver(mViewModel)
    }

    override fun onDestroy() {
        lifecycle.removeObserver(mViewModel)
        super.onDestroy()
    }
}