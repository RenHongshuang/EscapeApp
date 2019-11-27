package com.xiaobingdao.escape.ui.frame

import com.xiaobingdao.escape.base.ui.frame.common.model.EscapeAppFrameDomain
import com.xiaobingdao.escape.base.uiframe.common.interfaces.EscapeAppFrameInterface
import com.xiaobingdao.escape.base.uiframe.common.interfaces.EscapeAppFrameListInterface

class EscapeAppFrameList : EscapeAppFrameListInterface() {
    private var mHomeFrameList: MutableList<String> = mutableListOf()
    override fun getFrameList(): List<String> {
        mHomeFrameList.add(EscapeAppFrameDomain.Home.MYOWNEXPERIENCE)
        return mHomeFrameList
    }

    override fun getFrameInstanceByDomainClassName(frameDomain: String): EscapeAppFrameInterface? {
        val frameClassInstanceName: String = when (frameDomain) {
            EscapeAppFrameDomain.Home.MYOWNEXPERIENCE -> " com.xiaobingdao.escape.myownexperience.ui.frame.MyOwnExperienceFrame"
            else -> ""
        }
        if (frameDomain.isEmpty()) {
            return null
        }
        return newFrameInterfaceClassInstance(frameClassInstanceName, frameDomain)
    }
}