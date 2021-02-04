package com.jinggao.android.kotlinarouterdemo

import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import androidx.core.content.ContextCompat
import com.qmuiteam.qmui.arch.QMUIFragmentActivity
import com.qmuiteam.qmui.arch.annotation.DefaultFirstFragment
import com.qmuiteam.qmui.util.QMUIDisplayHelper
import com.qmuiteam.qmui.widget.QMUIViewPager
import com.qmuiteam.qmui.widget.tab.QMUITabSegment

@DefaultFirstFragment(MainFragment::class)
class MainActivity : QMUIFragmentActivity(){
    private val TAG = MainActivity::class.simpleName.toString()

    override fun onDestroy() {
        super.onDestroy()
        System.exit(0)
        Runtime.getRuntime().exit(0)
        android.os.Process.killProcess(android.os.Process.myPid())
        System.gc()
    }


    /**
     * 菜单、返回键响应
     */
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {

        }
        return true
    }


}
