package com.app.simon.cardsgame.util

import com.app.simon.base.util.MathUtil
import com.app.simon.cardsgame.data.Constant
import com.app.simon.cardsgame.models.Card
import java.util.*

/**
 * desc: CardUtil
 * date: 2017/8/9
 *
 * @author xw
 */

object CardUtil {

    /**
     * 获取问题主题
     */
    fun getThemeList(): MutableList<String>? {
        val themeList = ArrayList<String>()
        Constant.KEY_THEME.forEach {
            themeList.add(it)
        }
        return themeList
    }

    /**
     * 获取背景
     */
    fun getBgResIdList(): MutableList<Int>? {
        val bgResList = ArrayList<Int>()
        Constant.CARD_BG.forEach {
            bgResList.add(it)
        }
        return bgResList
    }

    /**
     * 获取背景Name
     */
    fun getBgResNameList(): MutableList<String>? {
        val bgResList = ArrayList<String>()
        Constant.CARD_BG_STR.forEach {
            bgResList.add(it)
        }
        return bgResList
    }

    /**
     * 获取好友档案问题
     */
    fun getFriendRecords(isShuffle: Boolean, bgImgId: Int = -1): MutableList<Card>? {
        val cardList = ArrayList<Card>()
        Constant.VALUE_FRIEND_RECORD.forEachIndexed { index, value ->
            val card = Card()
            if (bgImgId in (0..Constant.CARD_BG.size - 1)) {
                card.backImgId = Constant.CARD_BG[bgImgId]
                card.frontImgId = Constant.CARD_BG_FRONT[bgImgId]
            } else {
                val randomNum = MathUtil.getRandomNum(Constant.CARD_BG.size)
                card.backImgId = Constant.CARD_BG[randomNum]
                card.frontImgId = Constant.CARD_BG_FRONT[randomNum]
            }
            card.content = value
            cardList.add(card)
        }
        if (isShuffle) {
            Collections.shuffle(cardList)
        }
        return cardList
    }

    /**
     * 获取认识彼此36问
     */
    fun getAmazing36Records(isShuffle: Boolean, bgImgId: Int = -1): MutableList<Card>? {
        val cardList = ArrayList<Card>()
        Constant.VALUE_AMAZING_36.forEachIndexed { index, value ->
            val card = Card()
            if (bgImgId in (0..Constant.CARD_BG.size - 1)) {
                card.backImgId = Constant.CARD_BG[bgImgId]
                card.frontImgId = Constant.CARD_BG_FRONT[bgImgId]
            } else {
                val randomNum = MathUtil.getRandomNum(Constant.CARD_BG.size)
                card.backImgId = Constant.CARD_BG[randomNum]
                card.frontImgId = Constant.CARD_BG_FRONT[randomNum]
            }
            card.content = value
            cardList.add(card)
        }
        if (isShuffle) {
            Collections.shuffle(cardList)
        }

        return cardList
    }
}