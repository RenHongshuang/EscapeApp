package com.xiaobingdao.escape.architecturecomponent.ui.fragment

import android.os.Bundle
import android.util.Log
import com.hccn.smt.basesmt.ui.fragments.BaseMvvmFragmentV1
import com.xiaobingdao.escape.architecturecomponent.ui.viewmodel.MvvmDemoV1ViewModel

/**
 * Created by hs.ren on 2019/12/26.
 */

class MvvmDemoV1Fragment :BaseMvvmFragmentV1<MvvmDemoV1ViewModel>(MvvmDemoV1ViewModel::class) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("xiaobingdao","MvvmDemoV1Fragment onCreate")
    }
}