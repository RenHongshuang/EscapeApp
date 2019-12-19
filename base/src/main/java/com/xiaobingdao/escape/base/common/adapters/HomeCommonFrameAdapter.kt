package com.xiaobingdao.escape.base.common.adapters

import android.content.Context
import android.content.Intent
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xiaobingdao.escape.base.R
import com.xiaobingdao.escape.base.uiframe.common.interfaces.EscapeAppMenuListInterface

/**
 * Created by hs.ren on 2019/11/21.
 */

class HomeCommonFrameAdapter(val context: Context, private val frameMenuList: EscapeAppMenuListInterface, private val caller: EscapeAppMenuListInterface.Caller) : RecyclerView.Adapter<HomeCommonFrameAdapter.HomeCommonFrameViewHolder>(), View.OnClickListener {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeCommonFrameViewHolder {
        val homeCommonFrameViewHolder = HomeCommonFrameViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_screen_common_frame_menu_list_item_layout, parent, false))
        homeCommonFrameViewHolder.itemView.setOnClickListener(this)
        return homeCommonFrameViewHolder
    }

    override fun onBindViewHolder(holder: HomeCommonFrameViewHolder, position: Int) {
        val menu = frameMenuList.getMenuList(caller)[position]
        if (TextUtils.isEmpty(menu)) {
            return
        }

        val iconImageView = holder.itemView.findViewById<ImageView>(R.id.home_screen_common_frame_menu_list_item_imageView)
        val titleTextView = holder.itemView.findViewById<TextView>(R.id.home_screen_common_frame_menu_list_item_text)

        val iconResId = frameMenuList.getMenuIconResourceId(menu, caller)
        val titleResId = frameMenuList.getMenuTitleResourceId(menu, caller)
        iconImageView.setImageResource(iconResId)
        titleTextView.setText(titleResId)

        holder.itemView.tag = menu
    }

    override fun getItemCount(): Int {
        return frameMenuList.getMenuList(caller).size
    }

    override fun onClick(view: View?) {
        view?.let {
            val viewTag = view.tag
            val menu = viewTag as String
            val intent = frameMenuList.onMenuPressed(menu, context, caller)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }

    inner class HomeCommonFrameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}