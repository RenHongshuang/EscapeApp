package com.xiaobingdao.escape.architecturecomponent.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.viewModels
import com.hccn.smt.basesmt.ui.fragments.BaseMvvmFragmentV3
import com.xiaobingdao.escape.architecturecomponent.ui.viewmodel.MvvmDemoV3ViewModel
import com.xiaobingdao.escape.architecturecomponent.ui.viewmodel.MvvmDemoViewModelFractory

/**
 * Created by hs.ren on 2019/12/26.
 */

class MvvmDemoV3Fragment:BaseMvvmFragmentV3<MvvmDemoV3ViewModel>() {

    override val mViewModel :MvvmDemoV3ViewModel by viewModels {
        MvvmDemoViewModelFractory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("xiaobingdao","MvvmDemoV3Fragment onCreate")
    }
}