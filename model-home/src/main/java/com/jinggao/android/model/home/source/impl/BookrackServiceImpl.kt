package com.jinggao.android.model.home.source.impl

import com.jinggao.android.common.bean.BaseResult
import com.jinggao.android.common.bean.RankInfo
import com.jinggao.android.common.bean.RankType
import com.jinggao.android.common.net.base.BaseServiceImpl
import com.jinggao.android.common.net.bean.BaseApiResult
import com.jinggao.android.common.net.rxbus.RxBus
import com.jinggao.android.model.home.source.controller.BookrackController
import com.jinggao.android.model.home.source.service.BookrackService
import io.reactivex.Observable
import kotlinx.coroutines.Deferred

class BookrackServiceImpl private constructor() :
    BaseServiceImpl<BookrackController>(BookrackController::class.java), BookrackService {

    companion object {
        var instance: BookrackServiceImpl? = null
            get() {
                if (field == null) {
                    synchronized(BookrackServiceImpl::class.java) {
                        if (field == null) {
                            field = BookrackServiceImpl()
                        }
                    }
                }
                return field
            }
            private set
    }

    override fun rankingGender(): Deferred<BaseResult<RankType>> {
        return api?.rankingGender()!!
    }

    override fun ranking(rankId: String): Deferred<BaseResult<RankInfo>> {
        return api?.ranking(rankId)!!
    }
}
