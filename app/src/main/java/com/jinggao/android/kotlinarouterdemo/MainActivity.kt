package com.jinggao.android.kotlinarouterdemo

import android.graphics.Typeface
import android.os.Bundle
import android.view.KeyEvent
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.qmuiteam.qmui.arch.QMUIFragment
import com.qmuiteam.qmui.arch.QMUIFragmentActivity
import com.qmuiteam.qmui.arch.QMUIFragmentPagerAdapter
import com.qmuiteam.qmui.util.QMUIDisplayHelper
import com.qmuiteam.qmui.widget.tab.QMUITabSegment

class MainActivity : QMUIFragmentActivity(){


    private var viewpager: ViewPager? = null

    private var tabs: QMUITabSegment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tabs = findViewById(R.id.tab_segment)
        viewpager = findViewById(R.id.app_view_pager)

        initTab()
    }

    private fun initTab() {
        val adapter = object : QMUIFragmentPagerAdapter(supportFragmentManager) {
            override fun createFragment(position: Int): QMUIFragment {
                when (position){
                    0   ->  return com.jinggao.android.model.home.BookrackFragment()
                    1   -> return com.jinggao.android.model.rank.RankFragment()
                    2   -> return com.jinggao.android.model.classify.ClassifyFragment()
                    3   -> return com.jinggao.android.model.mine.MineFragment()
                }
                return com.jinggao.android.model.home.BookrackFragment();
            }

            override fun getCount(): Int {
                return 4
            }

            override fun getPageTitle(position: Int): CharSequence? {
                when (position){
                    0   ->  return "书架"
                    1   -> return  "排行"
                    2   -> return  "分类"
                    3   -> return  "我的"
                }
                return "书架"
            }
        }

        val builder = tabs?.tabBuilder()
        builder?.setTypeface(null, Typeface.DEFAULT_BOLD)
        builder?.setSelectedIconScale(1.1f)?.setTextSize(
            QMUIDisplayHelper.sp2px(this, 12),
            QMUIDisplayHelper.sp2px(this, 12)
        )?.setDynamicChangeIconColor(false)


        val bookrack = builder?.setNormalDrawable(ContextCompat.getDrawable(this, R.drawable.bookrack_normal))
                              ?.setSelectedDrawable(ContextCompat.getDrawable(this, R.drawable.bookrack_select))
                              ?.setText("书架")?.build(this)


        val rank = builder?.setNormalDrawable(ContextCompat.getDrawable(this, R.drawable.rank_normal))
                          ?.setSelectedDrawable(ContextCompat.getDrawable(this, R.drawable.rank_select))
                          ?.setText("排行")?.build(this)


        val classify = builder?.setNormalDrawable(ContextCompat.getDrawable(this, R.drawable.classify_normal))
                              ?.setSelectedDrawable(ContextCompat.getDrawable(this, R.drawable.classify_select))
                              ?.setText("分类")?.build(this)


        val mine = builder?.setNormalDrawable(ContextCompat.getDrawable(this, R.drawable.mine_normal))
                          ?.setSelectedDrawable(ContextCompat.getDrawable(this, R.drawable.mine_select))
                          ?.setText("我的")?.build(this)

        tabs?.addTab(bookrack)?.addTab(rank)?.addTab(classify)?.addTab(mine)
        viewpager?.adapter = adapter
        tabs?.setupWithViewPager(viewpager)

    }

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
