package com.jinggao.android.model.home.source.service

import com.jinggao.android.common.bean.BaseResult
import com.jinggao.android.common.bean.RankInfo
import com.jinggao.android.common.bean.RankType
import com.jinggao.android.common.net.bean.BaseApiResult
import io.reactivex.Observable
import kotlinx.coroutines.Deferred

interface BookrackService {
    fun rankingGender(): Deferred<BaseResult<RankType>>
    fun ranking(rankId: String): Deferred<BaseResult<RankInfo>>
}