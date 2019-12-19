package com.xiaobingdao.escape.base.uiframe.common.interfaces

import android.text.TextUtils
//import com.blankj.utilcode.util.LogUtils
import java.lang.reflect.InvocationTargetException

/**
 * Created by hs.ren on 2019/11/20.
 */

abstract class EscapeAppFrameListInterface {

    companion object {
        val TAG: String? = EscapeAppFrameListInterface::class.simpleName

    }

    abstract fun getFrameList(): List<String>

    abstract fun getFrameInstanceByDomainClassName(frameDomain: String): EscapeAppFrameInterface?

    protected fun newFrameInterfaceClassInstance(frameInterfaceClassName: String, frameDomain: String): EscapeAppFrameInterface? {
        if (TextUtils.isEmpty(frameInterfaceClassName) || TextUtils.isEmpty(frameDomain)) {
            return null
        }

        var aClass: Class<*>? = null
        try {
            aClass = Class.forName(frameInterfaceClassName)
        } catch (e: ClassNotFoundException) {
            //LogUtils.e(TAG, "newFrameInterfaceClassInstance. $e")
        }

        if (aClass == null) {
            //LogUtils.e(TAG, "newFrameInterfaceClassInstance. Invalid aClass.")
            return null
        }

        try {
            return aClass.getDeclaredConstructor(String::class.java).newInstance(frameDomain) as EscapeAppFrameInterface
        } catch (e: NoSuchMethodException) {
            //LogUtils.e(TAG, "newFrameInterfaceClassInstance. $e")
        } catch (e: SecurityException) {
            //LogUtils.e(TAG, "newFrameInterfaceClassInstance. $e")
        } catch (e: InstantiationException) {
            //LogUtils.e(TAG, "newFrameInterfaceClassInstance. $e")
        } catch (e: IllegalAccessException) {
            //LogUtils.e(TAG, "newFrameInterfaceClassInstance. $e")
        } catch (e: IllegalArgumentException) {
            //LogUtils.e(TAG, "newFrameInterfaceClassInstance. $e")
        } catch (e: InvocationTargetException) {
            //LogUtils.e(TAG, "newFrameInterfaceClassInstance. $e")
        }

        return null
    }

}