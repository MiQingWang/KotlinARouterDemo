package com.jinggao.android.common

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import com.qmuiteam.qmui.arch.QMUISwipeBackActivityManager
import com.qmuiteam.qmui.skin.QMUISkinManager

/**
 * @author jing.gao
 * @date 2020/8/28 10:48
 * @version 1.0
 */
class QmuiHelper {
    companion object{
        fun init( application: Application){
            QMUISwipeBackActivityManager.init(application)
            install(application,SKIN_BLUE)
        }

        const val SKIN_BLUE = 1
        const val SKIN_DARK = 2


        fun install(context: Context,index :Int) {
            val skinManager = QMUISkinManager.defaultInstance(context)
            skinManager.addSkin(SKIN_BLUE, R.style.app_skin_blue)
            skinManager.addSkin(SKIN_DARK, R.style.app_skin_dark)
            val isDarkMode = (context.resources.configuration.uiMode
                    and Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES
            val storeSkinIndex = index
            if (isDarkMode && storeSkinIndex != SKIN_DARK) {
                skinManager.changeSkin(SKIN_DARK)
            } else if (!isDarkMode && storeSkinIndex == SKIN_DARK) {
                skinManager.changeSkin(SKIN_BLUE)
            } else {
                skinManager.changeSkin(storeSkinIndex)
            }
        }

        fun changeSkin(index: Int, context: Context?) {
            QMUISkinManager.defaultInstance(context).changeSkin(index)
        }


    }
}