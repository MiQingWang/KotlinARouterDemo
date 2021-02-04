package com.jinggao.android.common.net.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.disposables.Disposable

/**
 * Rx权限获取工具类
 */
object RxPermissionsUtil {
    /**
     * fragment中使用
     * 验证权限是否获取成功
     * @param fragment  当前页面
     * @param permissionsGroup 多个权限数组
     * @param booleanConsumer 回调权限是否全部获取
     * @return
     */
    fun checkPermissionsHandler(
        fragment: Fragment,
        permissionsGroup: Array<String?>,
        booleanConsumer: androidx.core.util.Consumer<Boolean?>
    ): Disposable {
        val rxPermissions = RxPermissions(fragment)
        return rxPermissions.request(*permissionsGroup)
            .subscribe { t: Boolean? ->
                booleanConsumer.accept(
                    t
                )
            }
    }

    /**
     * activity中使用
     * 验证权限是否获取成功
     * @param fragmentActivity 当前页面
     * @param permissionsGroup 多个权限数组
     * @param booleanConsumer 回调权限是否全部获取
     * @return
     */
    fun checkPermissionsHandler(
        fragmentActivity: FragmentActivity,
        permissionsGroup: Array<String?>,
        booleanConsumer: androidx.core.util.Consumer<Boolean?>
    ): Disposable {
        val rxPermissions = RxPermissions(fragmentActivity)
        return rxPermissions.request(*permissionsGroup)
            .subscribe { t: Boolean? ->
                booleanConsumer.accept(
                    t
                )
            }
    }

    /**
     * 回收rx资源
     * @param disposable 创建的资源
     */
    fun destroyDisposable(disposable: Disposable?) {
        if (disposable != null && !disposable.isDisposed) {
            disposable.dispose()
        }
    }
}