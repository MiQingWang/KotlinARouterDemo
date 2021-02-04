package com.jinggao.android.common

import android.util.Log
import me.goldze.mvvmhabit.utils.ToastUtils

enum class LogEnum {
    VERBOSE, DEBUG, INFO, WARN, ERROR
}

fun String.log(logEnum: LogEnum = LogEnum.ERROR) {
    if (BuildConfig.DEBUG) {
        when (logEnum) {
            LogEnum.VERBOSE -> Log.v("jhb", this)
            LogEnum.DEBUG -> Log.d("jhb", this)
            LogEnum.INFO -> Log.i("jhb", this)
            LogEnum.WARN -> Log.w("jhb", this)
            LogEnum.ERROR -> Log.e("jhb", this)
        }
    }
}

fun String.logWithTag(tag: String, logEnum: LogEnum = LogEnum.ERROR) {
    if (BuildConfig.DEBUG) {
        when (logEnum) {
            LogEnum.VERBOSE -> Log.v(tag, this)
            LogEnum.DEBUG -> Log.d(tag, this)
            LogEnum.INFO -> Log.i(tag, this)
            LogEnum.WARN -> Log.w(tag, this)
            LogEnum.ERROR -> Log.e(tag, this)
        }
    }
}


fun String.showToast() {
    ToastUtils.showShort(this)
}



fun Any?.isNull() = this == null

fun Any?.isNotNull() = !isNull()