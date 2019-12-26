package com.hccn.smt.basesmt.ui.fragments

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.hccn.smt.basesmt.viewmodel.BaseViewModel
import com.xiaobingdao.escape.base.ui.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.reflect.KClass

/**
 * Created by hs.ren on 2019/12/19.
 */

abstract class BaseMvvmFragmentV2<VM : BaseViewModel>(clazz: KClass<VM>) : BaseFragment() {
    // @see Koin
    val mViewModel: VM by viewModel(clazz)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(mViewModel)
    }

    override fun onDestroy() {
        lifecycle.removeObserver(mViewModel)
        super.onDestroy()
    }
}