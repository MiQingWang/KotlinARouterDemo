package com.jinggao.android.common

import android.app.Application
import com.qmuiteam.qmui.arch.QMUISwipeBackActivityManager

/**
 * @author jing.gao
 * @date 2020/8/28 10:48
 * @version 1.0
 */
class QmuiHelper {
    companion object{
        fun init( application: Application){
            QMUISwipeBackActivityManager.init(application)
        }
    }
}