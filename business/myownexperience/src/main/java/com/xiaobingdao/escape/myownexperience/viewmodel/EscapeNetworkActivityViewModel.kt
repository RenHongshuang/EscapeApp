package com.xiaobingdao.escape.myownexperience.viewmodel


import android.util.Log
import androidx.lifecycle.viewModelScope
import com.hccn.smt.basesmt.viewmodel.BaseViewModel
import com.xiaobingdao.escape.base.launch
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import luyao.wanandroid.model.api.MyExperienceRetrofitClient


class EscapeNetworkActivityViewModel : BaseViewModel() {

    fun getData(){
       launch({
           val url =MyExperienceRetrofitClient.service.getImage().imgurl
           Log.d("xiaobingdao","xiaobingdao $url")
       },{
           Log.d("xiaobingdao","xiaobingdao error ${it.message}")
       })
    }
    override fun onDestroy() {
        Log.d("xiaobingdao","xiaobingdao")
    }
}