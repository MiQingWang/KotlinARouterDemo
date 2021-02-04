package com.jinggao.android.common.net

interface NetworkHeaderParams {
    //retrofit header中配置的参数名称
    //  @Headers({
    //            "token:true"
    //    })
    fun paramsName(): String

    //网络请求头中设置的header头参数名
    fun headerName(): String

    //网络请求头中设置的header头中的值
    fun headerValue(): String
}