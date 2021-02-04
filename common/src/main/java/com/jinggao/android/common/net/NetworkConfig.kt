package com.jinggao.android.common.net

import android.app.Application
import me.jessyan.rxerrorhandler.handler.listener.ResponseErrorListener
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class NetworkConfig {
    var releaseBaseUrl // release地址，根据工具编译的模式自动切换
            : String? = null
    var debugBaseUrl // debug地址，根据工具编译的模式自动切换
            : String? = null
    var application // Android 全局应用程序主类
            : Application? = null
    var logLevel //网络请求日志打印级别
            : HttpLoggingInterceptor.Level? = null
    var openCache //是否开启网络缓存，无网络时自动返回缓存内容
            : Boolean? = null
    var openRxCache // 是否开启RxCache数据缓存
            : Boolean? = null
    var networkHeaderParams // 自定义配置网络请求header信息
            : MutableList <NetworkHeaderParams>? = null
    var okHttpClientBuild //自定义配置OkhttpClient
            : OkHttpClient.Builder? = null
    var responseErrorListener // 自定义配置全局异常捕获监听
            : ResponseErrorListener? = null

}