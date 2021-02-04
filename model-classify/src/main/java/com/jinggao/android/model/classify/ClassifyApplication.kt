package com.jinggao.android.model.classify

import android.app.Application
import com.jinggao.android.common.Constant
import com.jinggao.android.common.KotlinApplication

/**
 * @author jing.gao
 * @date 2020/8/27 15:35
 * @version 1.0
 */
class ClassifyApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        KotlinApplication.init(this,ClassifyActivity::class.java)
    }
}