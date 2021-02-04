package com.jinggao.android.common.net.util

import android.content.Context
import android.net.ConnectivityManager

object NetworkUtil {
    /**
     * check NetworkAvailable
     * @param context
     * @return
     */
    fun isNetworkAvailable(context: Context): Boolean {
        val manager = context.applicationContext.getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
            ?: return false
        val info = manager.activeNetworkInfo
        return if (null == info || !info.isAvailable) false else true
    }
}