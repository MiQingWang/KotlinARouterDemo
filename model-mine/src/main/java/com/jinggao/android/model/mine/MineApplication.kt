package com.jinggao.android.model.mine

import android.app.Application
import com.jinggao.android.common.KotlinApplication

/**
 * @author jing.gao
 * @date 2020/8/27 15:35
 * @version 1.0
 */
class MineApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        KotlinApplication.init(BuildConfig.DEBUG,this)
    }
}