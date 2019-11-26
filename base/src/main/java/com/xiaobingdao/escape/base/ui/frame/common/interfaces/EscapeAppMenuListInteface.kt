package com.xiaobingdao.escape.base.uiframe.common.interfaces

import android.content.Context
import android.content.Intent
import java.util.ArrayList

/**
 * Created by hs.ren on 2019/11/21.
 */

abstract class EscapeAppMenuListInteface {

    companion object {
        // Merchant&Pos Mangement Frame
        val MERCHANT_POS_REG = "merchant_pos_reg"
        val MERCHANT_POS_MAINTAIN = "merchant_pos_maintain"
        val POSVISIT = "posvisit"
        val MATERIAL = "material"
        val DIALY_PAYMENT_LOAN = "daily_payment_laon"
        // Bussiness Chance Frame
        val BUSSINESS_CHANCE = "bussiness_chance"
        // People Mangement Frame
        val TIPPER = "tipepr"
    }

    enum class Caller {
        POS_MANGEMANT,
        BUSINESS_CHANCE_MANGEMANT,
        PEOPLE_MANGEMANT
    }

    abstract fun getMenuList(caller: Caller): MutableList<String>

    abstract fun getMenuTitleResourceId(menu: String, caller: Caller): Int

    abstract fun getMenuIconResourceId(menu: String, caller: Caller): Int

    abstract fun onMenuPressed(menu: String, context: Context, caller: Caller): Intent
}