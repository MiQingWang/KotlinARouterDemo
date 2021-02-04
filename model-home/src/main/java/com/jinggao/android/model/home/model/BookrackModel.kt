package com.jinggao.android.model.home.model

import com.jinggao.android.common.bean.BaseResult
import com.jinggao.android.common.bean.RankInfo
import com.jinggao.android.model.home.source.impl.BookrackServiceImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import me.goldze.mvvmhabit.base.BaseModel

class BookrackModel :BaseModel() {


    suspend  fun getBookcaseIsRecommendedList(): RankInfo?{
           return withContext(Dispatchers.IO){
               try {
                   val rankingGenderDeferred = BookrackServiceImpl.instance!!.rankingGender()
                   val rankingDeferred = BookrackServiceImpl.instance!!.ranking(
                       rankingGenderDeferred.await().male?.get(0)?._id!!).await().ranking
                   rankingDeferred
               } catch (e: Throwable) {
                   e.printStackTrace()
                   throw e
               }
           }
    }


}