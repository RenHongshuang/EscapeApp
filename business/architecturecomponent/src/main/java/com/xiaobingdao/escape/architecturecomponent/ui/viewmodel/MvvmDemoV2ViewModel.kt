package com.xiaobingdao.escape.architecturecomponent.ui.viewmodel

import android.util.Log
import com.hccn.smt.basesmt.viewmodel.BaseViewModel

/**
 * Created by hs.ren on 2019/12/26.
 */

class MvvmDemoV2ViewModel :BaseViewModel() {
    override fun onDestroy() {
        Log.d("xiaobingdao","MvvmDemoV2ViewModel ondestory")
    }
}