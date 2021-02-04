package com.jinggao.android.model.router

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter

/**
 * @author jing.gao
 * @date 2020/8/13 21:40
 * @version 1.0
 */
class ModelARouterHelper {

    companion object {
        fun init (isDeBug : Boolean , application: Application) {
            if(isDeBug){
                ARouter.openLog()
                ARouter.openDebug()
            }
            ARouter.init(application)
        }
    }


}