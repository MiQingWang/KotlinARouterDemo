package com.jinggao.android.common.net.base

import android.util.Log
import com.jinggao.android.common.net.NetworkLoader

class BaseRxCacheServiceImpl<RxCacheController>(clazz: Class<RxCacheController>?) {
    protected var api: RxCacheController? = null

    init {
        try {
            api =
                NetworkLoader.instance?.rxCache?.using(clazz)
        } catch (e: Exception) {
            Log.e(
                NetworkLoader.TAG,
                "RxCacheError: 配置网络框架时未开启RxCache配置,请检查"
            )
        }
    }
}