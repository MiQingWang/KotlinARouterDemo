package com.jinggao.android.common.binding.viewadapter

import androidx.databinding.BindingAdapter
import com.jinggao.android.common.LogEnum
import com.jinggao.android.common.logWithTag
import com.qmuiteam.qmui.widget.pullLayout.QMUIPullLayout
import me.goldze.mvvmhabit.binding.command.BindingCommand
import me.goldze.mvvmhabit.binding.command.BindingConsumer

class CustomAdapter {
    companion object {
        @JvmStatic
        @BindingAdapter(value = ["onQmRefreshCommand", "onQmLoadMoreCommand"], requireAll = false)
        fun setQmuiRefresh(
            qmuiPullLayout: QMUIPullLayout,
            onQmRefreshCommand: BindingCommand<BindingConsumer<Boolean>>?,
            onQmLoadMoreCommand: BindingCommand<BindingConsumer<Boolean>>?
        ) {
            qmuiPullLayout.setEnabledEdges(QMUIPullLayout.PULL_EDGE_TOP)
            if (onQmLoadMoreCommand != null) {
                qmuiPullLayout.setEnabledEdges(QMUIPullLayout.PULL_EDGE_TOP or QMUIPullLayout.PULL_EDGE_BOTTOM)
            }
            qmuiPullLayout.setActionListener { pullAction ->
                if (pullAction.pullEdge == QMUIPullLayout.PULL_EDGE_TOP) {
                    onQmRefreshCommand?.execute(BindingConsumer {
                        qmuiPullLayout.finishActionRun(
                            pullAction
                        )
                    })

                } else if (pullAction.pullEdge == QMUIPullLayout.PULL_EDGE_BOTTOM) {
                    onQmLoadMoreCommand?.execute(BindingConsumer {
                        qmuiPullLayout.finishActionRun(
                            pullAction
                        )
                    })
                }
            }
        }

        @JvmStatic
        @BindingAdapter(value = ["pullText"])
        fun loadText(qmuiPullLayout: QMUIPullLayout, pullText: String) {
            if(qmuiPullLayout!=null){
                pullText.logWithTag("CustomAdapter", LogEnum.ERROR)
            }
        }
    }

}

