package com.jinggao.android.common.net.bean

import java.io.Serializable

class BaseApiResult<T> : Serializable {
    var result = 0
    var data: T? = null
        private set
    var message: String? = null
    var time: String? = null

    fun setData(data: T) {
        this.data = data
    }
}