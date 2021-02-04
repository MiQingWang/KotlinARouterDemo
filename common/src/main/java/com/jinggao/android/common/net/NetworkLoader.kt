package com.jinggao.android.common.net

import android.app.Application
import android.text.TextUtils
import android.util.Log
import com.jinggao.android.common.net.base.BaseResponseErrorListenerImpl
import io.rx_cache2.internal.RxCache
import io.victoralbertos.jolyglot.GsonSpeaker
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import me.jessyan.rxerrorhandler.handler.listener.ResponseErrorListener
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.io.File
import java.util.*
import kotlin.collections.ArrayList

class NetworkLoader {
    private var networkConfig: NetworkConfig? = null
    var retrofit: Retrofit? = null
        private set
    var rxCache: RxCache? = null
        private set
    var rxErrorHandler: RxErrorHandler? = null
        private set

    private fun setNetworkConfig(networkConfig: NetworkConfig) {
        this.networkConfig = networkConfig
    }

    private fun build() {
        if (networkConfig == null) {
            Log.e(TAG, "未设置网络框架配置，清使用NetworkLoader.Build类创建")
        }
        if (TextUtils.isEmpty(networkConfig!!.debugBaseUrl) || TextUtils.isEmpty(
                networkConfig!!.releaseBaseUrl
            )
        ) {
            Log.e(TAG, "未设置网络框架基础请求地址,请配置debug或者release请求地址")
        }
        retrofit = Network(networkConfig!!).getRetrofitInstance()
        if (networkConfig!!.openRxCache!!) {
            val rxCacheDirectory =
                File(networkConfig!!.application!!.cacheDir, "common_rx_cache")
            if (!rxCacheDirectory.exists()) {
                rxCacheDirectory.mkdirs()
            }
            setRxCache(
                RxCache.Builder()
                    .persistence(rxCacheDirectory, GsonSpeaker())
            )
        }
        setRxErrorHandler(
            RxErrorHandler
                .builder()
                .with(networkConfig!!.application)
                .responseErrorListener(networkConfig!!.responseErrorListener).build()
        )
    }

    private fun setRxCache(rxCache: RxCache) {
        this.rxCache = rxCache
    }

    private fun setRxErrorHandler(rxErrorHandler: RxErrorHandler) {
        this.rxErrorHandler = rxErrorHandler
    }

    class Build(application: Application?) {
        private val networkConfig: NetworkConfig
        fun setBaseUrl(
            releaseBaseUrl: String?,
            debugBaseUrl: String?
        ): Build {
            networkConfig.releaseBaseUrl=releaseBaseUrl
            networkConfig.debugBaseUrl=debugBaseUrl
            return this
        }

        fun setLogLevel(logLevel: HttpLoggingInterceptor.Level?): Build {
            networkConfig.logLevel=logLevel
            return this
        }

        fun setOpenCache(isOpenCache: Boolean): Build {
            networkConfig.openCache=isOpenCache
            return this
        }

        fun setOpenRxCache(isOpenRxCache: Boolean): Build {
            networkConfig.openRxCache=isOpenRxCache
            return this
        }

        fun setNetworkHeaderParams(networkHeaderParams: NetworkHeaderParams?): Build {
            if (networkConfig.networkHeaderParams == null) {
                networkConfig.networkHeaderParams = ArrayList()
            }
            if (networkHeaderParams != null) {
                networkConfig.networkHeaderParams!!.add(networkHeaderParams)
            }
            return this
        }

        fun setOkHttpClientBuild(okHttpClientBuild: OkHttpClient.Builder?): Build {
            networkConfig.okHttpClientBuild=okHttpClientBuild
            return this
        }

        fun setResponseErrorListener(responseErrorListener: ResponseErrorListener?): Build {
            networkConfig.responseErrorListener=responseErrorListener
            return this
        }

        fun create(): Build {
            instance!!.setNetworkConfig(networkConfig)
            return this
        }

        fun build() {
            instance!!.build()
        }

        init {
            networkConfig = NetworkConfig()
            //设置默认配置
            networkConfig.application=application
            networkConfig.logLevel=HttpLoggingInterceptor.Level.NONE
            networkConfig.openCache=false
            networkConfig.openRxCache=false
            networkConfig.responseErrorListener=BaseResponseErrorListenerImpl()
        }
    }

    companion object {
        val TAG = NetworkLoader::class.java.simpleName

        //在retrofit设置api接口时header头设置参数开启
        const val DEFAULT_IS_ADD_HEADER = "true"
        private val networkLoaderMaps: MutableMap<String, NetworkLoader?> =
            HashMap()

        val instance: NetworkLoader?
            get() {
                if (!networkLoaderMaps.containsKey(TAG)) {
                    networkLoaderMaps[TAG] = NetworkLoader()
                }
                return networkLoaderMaps[TAG]
            }
    }
}