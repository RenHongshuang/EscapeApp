package com.xiaobingdao.escape.base.ui.frame.common.model

import android.text.TextUtils

/**
 * Created by hs.ren on 2019/11/20.
 */

class EscapeAppFrameDomain {
    class Home {
        companion object {
            /**
             * Page domain for Home Frames.
             */
            val PAGE_DOMAIN = "escape.app.home"

            // Parent Domains
            val MYOWNEXPERIENCE = "$PAGE_DOMAIN.myownexperience"
        }
    }

    class OtherPage {
        companion object {
            // TODO
        }
    }

    companion object {
        fun getFramePageDomain(frameDomain: String): String? {
            if (TextUtils.isEmpty(frameDomain)) {
                return null
            }

            if (frameDomain.startsWith(Home.PAGE_DOMAIN)) {
                return Home.PAGE_DOMAIN
            }
            return null
        }
    }
}