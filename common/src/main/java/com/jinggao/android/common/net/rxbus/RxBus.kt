package com.jinggao.android.common.net.rxbus

import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * 用RxJava实现事件总线(Event Bus)
 */
object RxBus {
    fun <T> ApplySchedulers(): ObservableTransformer<T, T> {
        return ObservableTransformer { tObservable: Observable<T> ->
            tObservable
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        }
    }
}