package com.jinggao.android.common.net

import android.util.Log
import androidx.core.app.CoreComponentFactory
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.jinggao.android.common.Constant
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

class Network(networkConfig: NetworkConfig) {

    private val TAG: String = Network::class.java.getSimpleName()

    //缓存最大容量
    private val CACHE_MAX_SIZE = 10 * 1024 * 1024
    private var networkConfig: NetworkConfig? = null

    init {
        this.networkConfig = networkConfig
    }

    private fun getOkHttpClientInstance(): OkHttpClient {
        //网络请求日志打印拦截器
        val httpLoggingInterceptor =
            HttpLoggingInterceptor { message -> Log.e(TAG, message) }
        //设置外部配置打印级别
        httpLoggingInterceptor.level= networkConfig!!.logLevel

        val builder: OkHttpClient.Builder

        //如果外部引用自定义了OkHttpClient.Builder 这里处理合并，否则走框架默认创建方法
        builder = if (networkConfig!!.okHttpClientBuild != null) {
            networkConfig!!.okHttpClientBuild!!
        } else {
            OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
        }
        //外部引用如果开启缓存，需要设置缓存拦截器，无网络时自动获取缓存数据
        if (networkConfig!!.openCache!!) {
            val httpCacheDirectory =
                File(networkConfig!!.application!!.cacheDir, "common_net_cache")
            try {
                val cache = Cache(httpCacheDirectory, CACHE_MAX_SIZE.toLong())
                builder.cache(cache)
            } catch (e: Exception) {
                Log.e(TAG, "Could not create http cache", e)
            }
            builder.addInterceptor(NetworkCacheInterceptor(networkConfig!!.application!!))
        }
        return builder //框架动态设置header头信息拦截器
            .addInterceptor(NetworkInterceptor(networkConfig!!.networkHeaderParams))
            .addInterceptor(httpLoggingInterceptor)
            .addNetworkInterceptor(httpLoggingInterceptor)
            .build()
    }


    fun getRetrofitInstance(): Retrofit? {
        return Retrofit.Builder()
            .baseUrl(if (Constant.DEBUG) networkConfig!!.debugBaseUrl else networkConfig!!.releaseBaseUrl)
            .client(getOkHttpClientInstance()) //增加返回值为String的支持
            .addConverterFactory(ScalarsConverterFactory.create()) //增加返回值为Gson的支持(以实体类返回)
            .addConverterFactory(GsonConverterFactory.create()) //增加返回值为Oservable<T>的支持
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }
}


