package com.xiaobingdao.escape.architecturecomponent.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.viewModels
import com.hccn.smt.basesmt.ui.fragments.BaseMvvmFragmentV3
import com.xiaobingdao.escape.architecturecomponent.ui.viewmodel.MvvmDemoV3ViewModel
import com.xiaobingdao.escape.architecturecomponent.ui.viewmodel.MvvmDemoV3ViewModelFactory
import com.xiaobingdao.escape.architecturecomponent.ui.viewmodel.MvvmDemoV5ViewModelFactory

/**
 * Created by hs.ren on 2019/12/26.
 */

class MvvmDemoV3Fragment:BaseMvvmFragmentV3<MvvmDemoV3ViewModel>() {

    override val mViewModel :MvvmDemoV3ViewModel by viewModels {
        MvvmDemoV3ViewModelFactory(context)
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