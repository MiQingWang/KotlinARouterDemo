package com.jinggao.android.model.router

class ARouterConstant {


    /**
     * 宿主
     */
    object App {
        private const val APP = "/app"

        /*首页*/
        const val FRAGMENT_EMPTY_PATH = "$APP/EmptyFragment"
        const val FRAGMENT_NAIN_PATH = "$APP/MainFragment"
    }


    /**
     * 首页组件
     */
    object Home {
        private const val HOME = "/home"

        /*首页*/
        const val FRAGMENT_HOME_PATH = "$HOME/HomeFragment"
    }


    /**
     * 我的组件
     */
    object Mine {
        private const val MINE = "/mine"

        /*我的*/
        const val FRAGMENT_MINE_PATH = "$MINE/MineFragment"
    }

    /**
     * 等级组件
     */
    object Rank {
        private const val RANK = "/rank"

        /*等级*/
        const val FRAGMENT_RANK_PATH = "$RANK/RankFragment"
    }

    /**
     * 分类组件
     */
    object Classify {
        private const val CLASSIFY = "/classify"

        /*分类*/
        const val FRAGMENT_CLASSIFY_PATH = "$CLASSIFY/ClassifyFragment"
    }

}