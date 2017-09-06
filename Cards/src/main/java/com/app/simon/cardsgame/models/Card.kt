package com.app.simon.cardsgame.models

/**
 * desc: 卡片
 * date: 2017/8/8

 * @author xw
 */
data class Card(
        /**
         * cardTheme : 性格
         * content : 问题具体内容
         * isFront : false
         */
        var cardTheme: String? = null,
        var name: String? = null,
        var content: String? = null,
        var frontImgId: Int = 0,
        var backImgId: Int = 0,
        var isFront: Boolean = false
)