package com.jinggao.android.kotlinarouterdemo

import android.graphics.Typeface
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.core.content.ContextCompat
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.jinggao.android.model.router.ARouterConstant
import com.qmuiteam.qmui.arch.QMUIFragment
import com.qmuiteam.qmui.arch.QMUIFragmentPagerAdapter
import com.qmuiteam.qmui.widget.QMUIViewPager
import com.qmuiteam.qmui.widget.tab.QMUITabSegment

@Route(path = ARouterConstant.App.FRAGMENT_NAIN_PATH)
class MainFragment : QMUIFragment() {
    private val TAG = MainFragment::class.simpleName.toString()
    private lateinit var viewpager: QMUIViewPager
    private lateinit var tabs: QMUITabSegment

    companion object {
        fun newInstance() = ARouter.getInstance().build(ARouterConstant.App.FRAGMENT_NAIN_PATH)
            .navigation() as MainFragment
    }

    override fun onCreateView(): View {
        return LayoutInflater.from(requireContext()).inflate(R.layout.activity_main, null)
    }

    override fun onViewCreated(rootView: View) {
        super.onViewCreated(rootView)
        tabs = rootView.findViewById(R.id.tab_segment)
        viewpager = rootView.findViewById(R.id.app_view_pager)
        initTab()
    }

    private fun initTab() {
        val adapter = object : QMUIFragmentPagerAdapter(parentFragmentManager) {
            override fun createFragment(position: Int): QMUIFragment {
                when (position) {
                    0 -> return (ARouter.getInstance()
                        .build(ARouterConstant.Home.FRAGMENT_HOME_PATH).navigation()
                        ?: ARouter.getInstance().build(ARouterConstant.App.FRAGMENT_EMPTY_PATH)
                            .navigation()) as QMUIFragment
                    1 -> return (ARouter.getInstance()
                        .build(ARouterConstant.Rank.FRAGMENT_RANK_PATH).navigation()
                        ?: ARouter.getInstance().build(ARouterConstant.App.FRAGMENT_EMPTY_PATH)
                            .navigation()) as QMUIFragment
                    2 -> return (ARouter.getInstance()
                        .build(ARouterConstant.Classify.FRAGMENT_CLASSIFY_PATH).navigation()
                        ?: ARouter.getInstance().build(ARouterConstant.App.FRAGMENT_EMPTY_PATH)
                            .navigation()) as QMUIFragment
                    3 -> return (ARouter.getInstance()
                        .build(ARouterConstant.Mine.FRAGMENT_MINE_PATH).navigation()
                        ?: ARouter.getInstance().build(ARouterConstant.App.FRAGMENT_EMPTY_PATH)
                            .navigation()) as QMUIFragment
                }
                return ARouter.getInstance().build(ARouterConstant.App.FRAGMENT_EMPTY_PATH)
                    .navigation() as QMUIFragment
            }

            override fun getCount(): Int {
                return 4
            }
        }
        val builder = tabs.tabBuilder()
        builder.setTypeface(null, Typeface.DEFAULT_BOLD)
        builder.setSelectedIconScale(1.1f)
            .setNormalIconSizeInfo(72, 72)
            .setDynamicChangeIconColor(false)
        val bookrack = builder.setNormalDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.mipmap.bookrack_normal
            )
        ).setSelectedDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.mipmap.bookrack_select
            )
        ).setText("书架").build(requireContext())


        val rank = builder.setNormalDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.mipmap.rank_normal
            )
        )
            .setSelectedDrawable(ContextCompat.getDrawable(requireContext(), R.mipmap.rank_select))
            .setText("排行")?.build(requireContext())


        val classify = builder.setNormalDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.mipmap.classify_normal
            )
        )
            .setSelectedDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.mipmap.classify_select
                )
            )
            .setText("分类")?.build(requireContext())


        val mine = builder.setNormalDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.mipmap.mine_normal
            )
        )
            .setSelectedDrawable(ContextCompat.getDrawable(requireContext(), R.mipmap.mine_select))
            .setText("我的")?.build(requireContext())
        tabs.addTab(bookrack)
        tabs.addTab(rank)
        tabs.addTab(classify)
        tabs.addTab(mine)
        Log.e(TAG, "initTab: " + tabs.childCount)
//        tabs?.addTab(bookrack)
        viewpager.adapter = adapter
        tabs.setupWithViewPager(viewpager,false)

    }

}