package com.xiaobingdao.escape.ui.frame

import com.xiaobingdao.escape.base.frame.model.EscapeAppFrameDomain
import com.xiaobingdao.escape.base.uiframe.common.interfaces.EscapeAppFrameInterface
import com.xiaobingdao.escape.base.uiframe.common.interfaces.EscapeAppFrameListInterface

class EscapeAppFrameList : EscapeAppFrameListInterface() {
    private var mHomeFrameList: MutableList<String> = mutableListOf()
    override fun getFrameList(): List<String> {
        mHomeFrameList.add(EscapeAppFrameDomain.Home.ARCHITECTURE_COMPONENT)
        mHomeFrameList.add(EscapeAppFrameDomain.Home.MY_OWN_EXPERIENCE)
        mHomeFrameList.add(EscapeAppFrameDomain.Home.BIG_FRONTEND)
        mHomeFrameList.add(EscapeAppFrameDomain.Home.UI_COMPONENT)
        return mHomeFrameList
    }

    override fun getFrameInstanceByDomainClassName(frameDomain: String): EscapeAppFrameInterface? {
        val frameClassInstanceName: String = when (frameDomain) {
            EscapeAppFrameDomain.Home.ARCHITECTURE_COMPONENT -> "com.xiaobingdao.escape.architecturecomponent.frame.ArchitectureComponentFrame"
            EscapeAppFrameDomain.Home.MY_OWN_EXPERIENCE -> "com.xiaobingdao.escape.myownexperience.frame.MyOwnExperienceFrame"
            EscapeAppFrameDomain.Home.BIG_FRONTEND -> "com.xiaobingdao.escape.bigfrontend.frame.BigFrontendFrame"
            EscapeAppFrameDomain.Home.UI_COMPONENT -> "com.xiaobingda.escape.uicomponent.frame.UiComponentFrame"
            else -> ""
        }
        if (frameDomain.isEmpty()) {
            return null
        }
        return newFrameInterfaceClassInstance(frameClassInstanceName, frameDomain)
    }
}