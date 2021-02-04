package com.jinggao.android.kotlinarouterdemo

import android.view.LayoutInflater
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.jinggao.android.model.router.ARouterConstant
import com.qmuiteam.qmui.arch.QMUIFragment

@Route(path = ARouterConstant.App.FRAGMENT_EMPTY_PATH)
class EmptyFragement : QMUIFragment() {

    override fun onCreateView(): View {
        return   LayoutInflater.from(getActivity()).inflate(R.layout.fragment_empty,null)
    }

}
