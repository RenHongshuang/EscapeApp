package com.xiaobingdao.escape.base.ui.frame.common.adapters

import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xiaobingdao.escape.base.R
import com.xiaobingdao.escape.base.ui.frame.common.model.FrameData
//import com.blankj.utilcode.util.LogUtils
import com.xiaobingdao.escape.base.uiframe.common.interfaces.EscapeAppFrameInterface
import com.xiaobingdao.escape.base.uiframe.common.interfaces.EscapeAppFrameListInterface

/**
 * Created by hs.ren on 2019/11/20.
 */

class EscapeAppFrameListAdapter(val context: Context?, private val frameListInterface: EscapeAppFrameListInterface?) : RecyclerView.Adapter<FrameViewHolder>(), View.OnClickListener {

    companion object {
        private val TAG = EscapeAppFrameListAdapter::class.java.simpleName
    }

    private var mFrameList: MutableList<EscapeAppFrameInterface>? = mutableListOf()

    init {
        val supportedFrameDomainList = frameListInterface?.getFrameList()
        supportedFrameDomainList?.forEach { frameName ->
            frameListInterface?.getFrameInstanceByDomainClassName(frameName)?.let {
                mFrameList?.add(it)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FrameViewHolder {
        val parentView: View
        val titleTextView: TextView
        val detailButton: ImageView
        val bodyLayout: ViewGroup
        when (viewType) {
            0 -> {
                parentView = LayoutInflater.from(parent.context).inflate(R.layout.frame_default_layout, parent, false)
                bodyLayout = parentView.findViewById(R.id.frame_default_layout_body)
                titleTextView = parentView.findViewById(R.id.frame_default_header_title)
                detailButton = parentView.findViewById(R.id.frame_default_layout_header_detail_button)
            }
            else -> {
                // TODO
                parentView = LayoutInflater.from(parent.context).inflate(R.layout.frame_default_layout, parent, false)
                return FrameViewHolder(parentView)
            }
        }
        val frameViewHolder = FrameViewHolder(parentView)
        frameViewHolder.titleTextView = titleTextView
        frameViewHolder.detailButton = detailButton
        frameViewHolder.bodyLayout = bodyLayout
        frameViewHolder.detailButton?.setOnClickListener(this)
        frameViewHolder.itemView.importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_NO
        return frameViewHolder
    }

    override fun onBindViewHolder(holder: FrameViewHolder, position: Int) {
        val frame = mFrameList?.get(position)

        holder.frameDomain = frame?.domain
        // Initialize itemView because it is recycled.
        holder.titleTextView?.visibility = View.VISIBLE
        holder.detailButton?.visibility = View.GONE
        holder.bodyLayout?.removeAllViewsInLayout()
        // set the itemView by FrameLayoutBinder
        val binder: EscapeAppFrameLayoutBinder = (frame as EscapeAppFrameInterface).onBindFrameView(context, FrameData())
        holder.titleTextView?.setText(binder.titleTextResId)
        holder.detailButton?.visibility = binder.detailButtonVisibility
        binder.bodyLayoutChildView?.let {
            addViewToBodyLayout(holder.bodyLayout, it)
        }
        holder.detailButton?.let {
            it.tag = holder
        }
    }

    override fun getItemCount(): Int {
        return mFrameList?.size ?: 0
    }

    override fun onClick(view: View?) {
        val viewHolder = view?.tag as FrameViewHolder
        val frame = getFrame(viewHolder.frameDomain ?: "")
        when (view.id) {
            R.id.frame_default_layout_header_detail_button -> {
                frame?.onFrameLayoutClick(EscapeAppFrameLayoutUpdater.ViewId.HEADER_BUTTON_LAYOUT)
            }
            R.id.frame_default_layout_body -> {
                frame?.onFrameLayoutClick(EscapeAppFrameLayoutUpdater.ViewId.BODY_LAYOUT)
            }
            else -> {
            }
        }
    }

    override fun onViewRecycled(holder: FrameViewHolder) {
        super.onViewRecycled(holder)
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
    }

    override fun onViewAttachedToWindow(holder: FrameViewHolder) {
        super.onViewAttachedToWindow(holder)
    }

    override fun onViewDetachedFromWindow(holder: FrameViewHolder) {
        super.onViewDetachedFromWindow(holder)
    }

    fun notifyFrameListAboutToDestroyed() {

        mFrameList?.let {
            for (frame in it) {
                frame.onUnbindFrameView(true)
                //LogUtils.i(TAG, "notifyFrameListAboutToDestroyed. Unbind Frame view. [" + frame.domain + "]")
            }

        }
    }

    private fun getFrame(frameDomain: String): EscapeAppFrameInterface? {
        if (frameDomain.isNotEmpty()) {
            mFrameList?.let {
                for (frame in it) {
                    frame.let {
                        if (TextUtils.equals(frameDomain, frame.domain)) {
                            return frame
                        }
                    }

                }
            }
        }
        return null
    }

    private fun addViewToBodyLayout(bodyLayout: ViewGroup?, view: View?) {
        val parent = view?.parent
        parent?.let {
            (it as ViewGroup).removeView(view)
        }
        bodyLayout?.addView(view)
    }

}