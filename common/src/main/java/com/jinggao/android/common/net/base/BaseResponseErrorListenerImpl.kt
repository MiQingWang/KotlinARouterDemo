package com.jinggao.android.common.net.base

import android.annotation.SuppressLint
import android.content.Context
import android.net.ParseException
import android.util.Log
import android.widget.Toast
import com.google.gson.JsonIOException
import com.google.gson.JsonParseException
import com.jinggao.android.common.net.NetworkLoader
import me.jessyan.rxerrorhandler.handler.listener.ResponseErrorListener
import org.json.JSONException
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class BaseResponseErrorListenerImpl : ResponseErrorListener {
    @SuppressLint("ShowToast")
    override fun handleResponseError(
        context: Context,
        t: Throwable
    ) {
        Log.e(NetworkLoader.TAG, "RxError 捕获", t)
        //这里只是对几个常用错误进行简单的处理, 展示这个类的用法, 在实际开发中请您自行对更多错误进行更严谨的处理
        var msg = "未知错误"
        if (t is UnknownHostException) {
            msg = "网络不可用"
        } else if (t is SocketTimeoutException) {
            msg = "请求网络超时"
        } else if (t is HttpException) {
            msg = convertStatusCode(t)
        } else if (t is JsonParseException || t is ParseException || t is JSONException || t is JsonIOException) {
            msg = "数据解析错误"
        }
        Toast.makeText(context, msg, Toast.LENGTH_SHORT)
    }

    private fun convertStatusCode(httpException: HttpException): String {
        val msg: String
        msg = if (httpException.code() == 500) {
            "服务器发生错误"
        } else if (httpException.code() == 404) {
            "请求地址不存在"
        } else if (httpException.code() == 403) {
            "请求被服务器拒绝"
        } else if (httpException.code() == 307) {
            "请求被重定向到其他页面"
        } else {
            httpException.message()
        }
        return msg
    }
}