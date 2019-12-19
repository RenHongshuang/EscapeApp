package com.xiaobingdao.escape.base.common.adapters

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by hs.ren on 2019/11/20.
 */

class FrameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var frameDomain: String? = null
    var titleTextView: TextView? = null
    var detailButton: ImageView? = null
    var bodyLayout: ViewGroup? = null
}