package com.jinggao.android.model.home.source.controller

import com.jinggao.android.common.bean.BaseResult
import com.jinggao.android.common.bean.RankInfo
import com.jinggao.android.common.bean.RankType
import com.jinggao.android.common.net.bean.BaseApiResult
import io.reactivex.Observable
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface BookrackController {
    @GET("ranking/gender")
    fun rankingGender(): Deferred<BaseResult<RankType>>

    @GET("ranking/{rankId}")
    fun ranking(@Path("rankId") rankId: String): Deferred<BaseResult<RankInfo>>

}
