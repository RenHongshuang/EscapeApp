package com.xiaobingdao.escape.architecturecomponent.ui.viewmodel

import android.util.Log
import com.hccn.smt.basesmt.viewmodel.BaseViewModel
import com.xiaobingdao.escape.architecturecomponent.ui.MvvmDemoV3Repository

/**
 * Created by hs.ren on 2019/12/26.
 */

class MvvmDemoV3ViewModel(val mRepository :MvvmDemoV3Repository) :BaseViewModel() {

    override fun onDestroy() {
       Log.d("xiaobingdao","MvvmDemoV3ViewModel ondestory")
    }
}