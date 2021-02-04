package com.jinggao.android.model.mine

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.jinggao.android.model.router.ARouterConstant
import com.qmuiteam.qmui.arch.QMUIFragment

@Route(path = ARouterConstant.Mine.FRAGMENT_MINE_PATH)
class MineFragment : QMUIFragment() {
    override fun onCreateView(): View {
        return   LayoutInflater.from(getActivity()).inflate(R.layout.fragment_mine,null)
    }

}
