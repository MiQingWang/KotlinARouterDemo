package com.jinggao.android.common.net.rxbus

/***
 * rxbus事件
 * @param <T>
</T> */
class RxBusEvent<T> {
    var event: Long = 0
    var tag: String? = null
    var data: T? = null
        private set
    var des: String? = null

    private constructor() {}
    private constructor(tag: String, data: T) {
        event = System.currentTimeMillis()
        this.tag = tag
        this.data = data
    }

    private constructor(tag: String, data: T, des: String) {
        event = System.currentTimeMillis()
        this.tag = tag
        this.data = data
        this.des = des
    }

    fun setData(data: T) {
        this.data = data
    }

    companion object {
        fun <T> newInstance(): RxBusEvent<Any> {
            return RxBusEvent<Any>()
        }

        fun <T> newInstance(tag: String, data: T): RxBusEvent<T> {
            return RxBusEvent(tag, data)
        }

        fun <T> newInstance(tag: String, data: T, des: String): RxBusEvent<T> {
            return RxBusEvent(tag, data, des)
        }

        fun <T> newInstance(
            tag: String,
            dataList: List<T>,
            des: String
        ): RxBusEvent<List<T>> {
            return RxBusEvent(tag, dataList, des)
        }
    }
}
