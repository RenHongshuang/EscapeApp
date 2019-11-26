package com.xiaobingdao.escape.base.ui.frame.common.adapters

import android.view.View

/**
 * Created by hs.ren on 2019/11/20.
 */

open class EscapeAppFrameLayoutUpdater {
    class ViewId {
        companion object {
            val HEADER_BUTTON_LAYOUT = 1
            val BODY_LAYOUT = 2
        }
    }

    var detailButtonVisibility = View.INVISIBLE
    var bodyLayoutChildView: View? = null
}