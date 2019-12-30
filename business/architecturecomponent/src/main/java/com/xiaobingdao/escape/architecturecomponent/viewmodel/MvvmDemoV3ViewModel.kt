package com.xiaobingdao.escape.architecturecomponent.viewmodel

import android.util.Log
import com.hccn.smt.basesmt.viewmodel.BaseViewModel
import com.xiaobingdao.escape.architecturecomponent.MvvmDemoRepository

/**
 * Created by hs.ren on 2019/12/26.
 */

class MvvmDemoV3ViewModel(val mRepository : MvvmDemoRepository) :BaseViewModel() {

    override fun onDestroy() {
       Log.d("xiaobingdao","MvvmDemoV3ViewModel ondestory")
    }
}