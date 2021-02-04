package com.jinggao.android.model.classify

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.jinggao.android.model.router.ARouterConstant
import com.qmuiteam.qmui.arch.QMUIFragment

@Route(path = ARouterConstant.Classify.FRAGMENT_CLASSIFY_PATH)
class ClassifyFragment : QMUIFragment() {

    override fun onCreateView(): View {
        return   LayoutInflater.from(getActivity()).inflate(R.layout.fragment_classify,null)
    }


}
