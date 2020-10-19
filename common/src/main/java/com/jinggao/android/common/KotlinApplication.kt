package com.jinggao.android.common

import android.app.Application
import com.jinggao.android.model.router.ModelArouterHelper
import me.jessyan.autosize.AutoSizeConfig
import me.jessyan.autosize.unit.Subunits

/**
 * @author jing.gao
 * @date 2020/8/12 13:18
 * @version 1.0
 */
open class KotlinApplication {
    companion object{
        fun init(isDeBug : Boolean , application: Application){
            ModelArouterHelper.init(isDeBug, application)
            QmuiHelper.init(application)

            AutoSizeConfig.getInstance().getUnitsManager()
                .setSupportDP(false)
                .setSupportSP(false).supportSubunits = Subunits.MM

            AutoSizeConfig.getInstance()
                //按照宽度适配 默认true
                .setBaseOnWidth(true).isCustomFragment = true
        }
    }

}