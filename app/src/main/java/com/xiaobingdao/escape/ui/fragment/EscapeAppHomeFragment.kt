package com.xiaobingdao.escape.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xiaobingdao.escape.R
import com.xiaobingdao.escape.base.common.adapters.EscapeAppFrameListAdapter
import com.xiaobingdao.escape.ui.frame.EscapeAppFrameList

class EscapeAppHomeFragment : Fragment() {
    private lateinit var mFrameRv: RecyclerView

    private lateinit var mFrameListAdapter: EscapeAppFrameListAdapter

    companion object {
        @JvmStatic
        fun newInstance() = EscapeAppHomeFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        mFrameRv = root.findViewById(R.id.recycler_platform)
        mFrameRv.layoutManager = LinearLayoutManager(context)
        mFrameListAdapter = EscapeAppFrameListAdapter(context, EscapeAppFrameList())
        mFrameRv.adapter = mFrameListAdapter
        return root
    }
}