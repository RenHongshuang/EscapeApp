package com.xiaobingdao.escape.architecturecomponent.ui.fragment

import android.os.Bundle
import android.util.Log
import com.hccn.smt.basesmt.ui.fragments.BaseMvvmFragmentV2
import com.xiaobingdao.escape.architecturecomponent.ui.viewmodel.MvvmDemoV2ViewModel

/**
 * Created by hs.ren on 2019/12/26.
 */

class MvvmDemoV2Fragment : BaseMvvmFragmentV2<MvvmDemoV2ViewModel>(MvvmDemoV2ViewModel::class) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("xiaobingdao","MvvmDemoV2Fragment onCreate")
    }
}