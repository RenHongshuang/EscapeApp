package com.xiaobingdao.escape.base.ui.frame.common.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.annotation.LayoutRes
import androidx.annotation.NonNull
import androidx.annotation.StringRes

/**
 * Created by hs.ren on 2019/11/20.
 */

class EscapeAppFrameLayoutBinder : EscapeAppFrameLayoutUpdater() {
    /**
     * Please set this with string resource ID for Title TextView in Header layout for your Frame.
     * Frame title should support multi-language.
     */
    @StringRes
    var titleTextResId = -1

    companion object {
        private val TAG = EscapeAppFrameLayoutBinder::class.simpleName
    }

    /**
     * Please call this method to inflate your own layout(xml) which will be added to Body layout for your Frame.
     *
     * @param context  Context to create an instance of LayoutInflater.
     * @param resource your own layout(xml) resource ID of Body layout.
     * @return The root View of  which is inflated from
     */
    fun inflateBodyLayoutChildView(@NonNull context: Context, @LayoutRes resource: Int): View? {
        val inflater = LayoutInflater.from(context)

        val root = FrameLayout(context)
        val params = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT)
        root.layoutParams = params

        return inflater.inflate(resource, root, false)
    }

}