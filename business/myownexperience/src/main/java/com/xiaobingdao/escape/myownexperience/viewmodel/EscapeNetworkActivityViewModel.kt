package com.xiaobingdao.escape.myownexperience.viewmodel


import android.util.Log
import com.hccn.smt.basesmt.viewmodel.BaseViewModel
import com.xiaobingdao.escape.base.launch
import com.xiaobingdao.escape.myownexperience.network.MyExperienceRetrofitClient
import com.xiaobingdao.escape.myownexperience.repository.MyExperienceNetworkDemoRepository


class EscapeNetworkActivityViewModel : BaseViewModel() {

    fun getData(){
       launch({
           val url = MyExperienceRetrofitClient.service.getImage().data.imgurl
           Log.d("xiaobingdao","xiaobingdao $url")
       },{
           Log.d("xiaobingdao","xiaobingdao error ${it.message}")
       })
    }

    fun getImageData(){
        launch({
            MyExperienceNetworkDemoRepository().getImageData()
        })
    }
    override fun onDestroy() {
        Log.d("xiaobingdao","xiaobingdao")
    }
}