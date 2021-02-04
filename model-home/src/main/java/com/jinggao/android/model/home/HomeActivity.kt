package com.jinggao.android.model.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.qmuiteam.qmui.arch.QMUIFragmentActivity

class HomeActivity : QMUIFragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity_home)
    }
}
