package com.xiaobingdao.escape.architecturecomponent.fragment

import android.os.Bundle
import android.util.Log
import com.hccn.smt.basesmt.ui.fragments.BaseMvvmFragmentV3
import com.xiaobingdao.escape.architecturecomponent.activity.MvvmDemoActivity
import com.xiaobingdao.escape.architecturecomponent.utils.obtainViewModel
import com.xiaobingdao.escape.architecturecomponent.viewmodel.MvvmDemoV4ViewModel

/**
 * Created by hs.ren on 2019/12/26.
 */

class MvvmDemoV4Fragment:BaseMvvmFragmentV3<MvvmDemoV4ViewModel>() {

    override lateinit var mViewModel: MvvmDemoV4ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = (activity as MvvmDemoActivity).obtainViewModel(MvvmDemoV4ViewModel::class.java)
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