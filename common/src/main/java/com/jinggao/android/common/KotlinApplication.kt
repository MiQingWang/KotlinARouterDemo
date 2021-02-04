package com.jinggao.android.common

import android.app.Activity
import android.app.Application
import androidx.annotation.Nullable
import com.jinggao.android.common.net.NetworkLoader
import com.jinggao.android.model.router.ModelARouterHelper
import me.goldze.mvvmhabit.base.BaseApplication
import me.goldze.mvvmhabit.crash.CaocConfig
import me.goldze.mvvmhabit.utils.KLog
import me.jessyan.autosize.AutoSizeConfig
import me.jessyan.autosize.unit.Subunits
import okhttp3.logging.HttpLoggingInterceptor


/**
 * @author jing.gao
 * @date 2020/8/12 13:18
 * @version 1.0
 */
open class KotlinApplication {
    companion object{
        fun init(application: Application, @Nullable restartActivityClass: Class<out Activity?>?){
            ModelARouterHelper.init(Constant.DEBUG, application)
            QmuiHelper.init(application)
            AutoSizeConfig.getInstance().getUnitsManager()
                .setSupportDP(false)
                .setSupportSP(false).supportSubunits = Subunits.MM
            AutoSizeConfig.getInstance()
                //按照宽度适配 默认true
                .setBaseOnWidth(true).isCustomFragment = true
            BaseApplication.setApplication(application)
            //是否开启日志打印

            //是否开启日志打印
            KLog.init(true)
            //配置全局异常崩溃操作
            //配置全局异常崩溃操作
            CaocConfig.Builder.create()
                .backgroundMode(CaocConfig.BACKGROUND_MODE_SILENT) //背景模式,开启沉浸式
                .enabled(true) //是否启动全局异常捕获
                .showErrorDetails(true) //是否显示错误详细信息
                .showRestartButton(true) //是否显示重启按钮
                .trackActivities(true) //是否跟踪Activity
                .minTimeBetweenCrashesMs(2000) //崩溃的间隔时间(毫秒)
                .restartActivity(restartActivityClass) //重新启动后的activity
                //.errorActivity(YourCustomErrorActivity.class) //崩溃后的错误activity
                //.eventListener(new YourCustomEventListener()) //崩溃后的错误监听
                .apply()

            NetworkLoader.Build(application)
                .setBaseUrl("http://api.zhuishushenqi.com/", "http://api.zhuishushenqi.com/")
                .setLogLevel(HttpLoggingInterceptor.Level.BODY)
//                .setOpenCache(true)
//                .setOpenRxCache(true) //自定义token设置
//                .setNetworkHeaderParams(自定义)
                //自定义网络异常处理
//                .setResponseErrorListener(自定义)
                .create().build()

        }
    }

}