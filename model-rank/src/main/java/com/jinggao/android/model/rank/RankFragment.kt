package com.jinggao.android.model.rank

import android.view.LayoutInflater
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.jinggao.android.model.router.ARouterConstant
import com.qmuiteam.qmui.arch.QMUIFragment


@Route(path = ARouterConstant.Rank.FRAGMENT_RANK_PATH)
class RankFragment : QMUIFragment() {
    override fun onCreateView(): View {
        return   LayoutInflater.from(getActivity()).inflate(R.layout.fragment_rank,null)
    }

}
