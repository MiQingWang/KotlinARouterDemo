package com.jinggao.android.common.net.base

import android.util.Log
import com.jinggao.android.common.net.NetworkLoader

open class BaseServiceImpl<Controller>(clazz: Class<Controller>) {

    protected var api: Controller? = null

    init {
        try {
            api =
                NetworkLoader.instance?.retrofit?.create(clazz)
        } catch (e: Exception) {
            Log.e(
                NetworkLoader.TAG,
                "RetrofitError: 配置网络框架时未执行build初始化,请检查"
            )
        }
    }
}
