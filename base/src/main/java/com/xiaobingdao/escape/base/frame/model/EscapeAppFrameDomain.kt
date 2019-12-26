package com.xiaobingdao.escape.base.frame.model

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
            val ARCHITECTURE_COMPONENT =  "$PAGE_DOMAIN.architectureComponent"
            val MY_OWN_EXPERIENCE = "$PAGE_DOMAIN.myOwnExperience"
            val BIG_FRONTEND = "$PAGE_DOMAIN.bigFrontend"
            val UI_COMPONENT ="$PAGE_DOMAIN，uiComponent"
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