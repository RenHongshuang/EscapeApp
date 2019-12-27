package com.xiaobingdao.escape.architecturecomponent.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.viewModels
import com.hccn.smt.basesmt.ui.fragments.BaseMvvmFragmentV3
import com.xiaobingdao.escape.architecturecomponent.ui.utils.InjectorUtils
import com.xiaobingdao.escape.architecturecomponent.ui.viewmodel.MvvmDemoV5ViewModel

/**
 * Created by hs.ren on 2019/12/26.
 */

class MvvmDemoV5Fragment:BaseMvvmFragmentV3<MvvmDemoV5ViewModel>() {

     override val mViewModel: MvvmDemoV5ViewModel by viewModels {
        InjectorUtils.provideMvvmDemoV5ViewModelFactory(requireContext())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("xiaobingdao","MvvmDemoV3Fragment onCreate")
    }

    override fun initView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun startObserve() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}