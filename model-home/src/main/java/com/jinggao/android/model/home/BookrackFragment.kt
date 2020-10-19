package com.jinggao.android.model.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.qmuiteam.qmui.arch.QMUIFragment


class BookrackFragment : QMUIFragment() {

    override fun onCreateView(): View {
        return   LayoutInflater.from(getActivity()).inflate(R.layout.fragment_bookrack,null)
    }

}
