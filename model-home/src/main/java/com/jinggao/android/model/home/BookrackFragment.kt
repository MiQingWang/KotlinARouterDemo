package com.jinggao .android.model.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.alibaba.android.arouter.facade.annotation.Route
import com.jinggao.android.common.base.BaseFragment
import com.jinggao.android.model.home.adapter.RecyclerBookrackAdapter
import com.jinggao.android.model.home.databinding.FragmentBookrackBinding
import com.jinggao.android.model.home.viewmodel.BookrackViewModel
import com.jinggao.android.model.router.ARouterConstant


@Route(path = ARouterConstant.Home.FRAGMENT_HOME_PATH)
class BookrackFragment : BaseFragment<FragmentBookrackBinding, BookrackViewModel>() {


    override fun initContentView(): Int {
        return  R.layout.fragment_bookrack
    }

    override fun initVariableId(): Int {
     return BR.viewModel
    }


    override fun initData() {
        super.initData()
        binding?.bookRackTopbar?.topBar?.setTitle("书架")
        binding?.adapter = RecyclerBookrackAdapter()
    }


}
