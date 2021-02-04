package com.jinggao.android.common.bean

data class Book(
    val _id: String,
    val allowMonthly: Boolean,
    val author: String,
    val banned: Int,
    var cover: String,
    val latelyFollower: Int,
    val majorCate: String,
    val minorCate: String,
    val retentionRatio: String,
    val shortIntro: String,
    val site: String,
    val title: String
)