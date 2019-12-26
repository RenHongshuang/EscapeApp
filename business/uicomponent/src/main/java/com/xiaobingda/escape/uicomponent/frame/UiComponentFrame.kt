package com.xiaobingda.escape.uicomponent.frame

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xiaobingda.escape.uicomponent.R
import com.xiaobingda.escape.uicomponent.menu.UiComponentMenuList
import com.xiaobingdao.escape.base.frame.adapter.EscapeAppFrameLayoutBinder
import com.xiaobingdao.escape.base.frame.adapter.EscapeAppFrameLayoutUpdater
import com.xiaobingdao.escape.base.frame.adapter.HomeCommonFrameAdapter
import com.xiaobingdao.escape.base.frame.model.FrameData
import com.xiaobingdao.escape.base.uiframe.common.interfaces.EscapeAppFrameInterface
import com.xiaobingdao.escape.base.uiframe.common.interfaces.EscapeAppMenuListInterface

/**
 * Created by hs.ren on 2019/12/26.
 */

class UiComponentFrame (frameDomain: String) : EscapeAppFrameInterface(frameDomain, UiComponentFrame::class) {
    override fun onBindFrameView(context: Context?, frameData: FrameData): EscapeAppFrameLayoutBinder {
        val escapeAppFrameLayoutBinder = EscapeAppFrameLayoutBinder()
        context?.let {
            val childView = escapeAppFrameLayoutBinder.inflateBodyLayoutChildView(context, R.layout.frame_home_common_detail_layout)
            escapeAppFrameLayoutBinder.detailButtonVisibility = View.GONE
            escapeAppFrameLayoutBinder.titleTextResId = R.string.ui_comopnent
            escapeAppFrameLayoutBinder.bodyLayoutChildView = childView
            childView?.let {
                val recyclerView = it.findViewById<RecyclerView>(R.id.frame_common_detail_body_rv)
                recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                recyclerView.adapter = HomeCommonFrameAdapter(context, UiComponentMenuList(), EscapeAppMenuListInterface.Caller.UI_COMPONENT)
            }
        }
        return escapeAppFrameLayoutBinder
    }

    override fun onUpdateFrameView(frameData: FrameData): EscapeAppFrameLayoutUpdater {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFrameHiddenChanged(isFrameHidden: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onUnbindFrameView(isDestroyed: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}