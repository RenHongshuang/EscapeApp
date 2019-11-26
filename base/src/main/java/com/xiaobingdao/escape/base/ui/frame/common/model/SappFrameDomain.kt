package com.hccn.sapp.homescreen.platform.frame.common.model

import android.text.TextUtils

/**
 * Created by hs.ren on 2019/11/20.
 */

class SappFrameDomain {
    class Home {
        companion object {
            /**
             * Page domain for Home Frames.
             */
            val PAGE_DOMAIN = "sapp.home"

            // Parent Domains
            val MERCHANT_POS_MANGEMENYT = "$PAGE_DOMAIN.merchantposmangement"
            val BUSINESS_CHANCE = "$PAGE_DOMAIN.businesschance"
            val PEOPLE_MANGEMENT = "$PAGE_DOMAIN.PeopleMangement"
            val HOME_BANNER = "$PAGE_DOMAIN.HomeBanner"
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