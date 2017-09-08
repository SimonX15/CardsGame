package com.app.simon.cardsgame.util

import com.app.simon.base.util.MathUtil
import com.app.simon.cardsgame.R
import com.app.simon.cardsgame.data.Constant
import com.app.simon.cardsgame.models.Card
import com.app.simon.cardsgame.models.CardImg
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

    /** 获取背景图片 */
    fun getCardImgList(): MutableList<CardImg>? {
        val cardImgList = ArrayList<CardImg>()
        cardImgList.add(CardImg(name = "默认", backImgId = R.mipmap.ic_bg_default, frontImgId = R.mipmap.ic_bg_default_front))
        cardImgList.add(CardImg(name = "火焰之歌", backImgId = R.mipmap.ic_bg_fire, frontImgId = R.mipmap.ic_bg_fire_front))
        cardImgList.add(CardImg(name = "雄鹰展翅", backImgId = R.mipmap.ic_bg_eagle, frontImgId = R.mipmap.ic_bg_eagle_front))
        cardImgList.add(CardImg(name = "彩虹之约", backImgId = R.mipmap.ic_bg_rainbow, frontImgId = R.mipmap.ic_bg_rainbow_front))
        cardImgList.add(CardImg(name = "冰雪奇缘", backImgId = R.mipmap.ic_bg_ice, frontImgId = R.mipmap.ic_bg_ice_front))
        cardImgList.add(CardImg(name = "炫彩宝石", backImgId = R.mipmap.ic_bg_gem, frontImgId = R.mipmap.ic_bg_gem_front))
        cardImgList.add(CardImg(name = "媚惑水晶", backImgId = R.mipmap.ic_bg_crystal, frontImgId = R.mipmap.ic_bg_crystal_front))
        cardImgList.add(CardImg(name = "胜利之羽", backImgId = R.mipmap.ic_bg_feather, frontImgId = R.mipmap.ic_bg_feather_front))
        cardImgList.add(CardImg(name = "金之术士", backImgId = R.mipmap.ic_bg_gold, frontImgId = R.mipmap.ic_bg_gold_front))
        cardImgList.add(CardImg(name = "金色灿烂", backImgId = R.mipmap.ic_bg_golden, frontImgId = R.mipmap.ic_bg_golden_front))
        cardImgList.add(CardImg(name = "生命赞歌", backImgId = R.mipmap.ic_bg_life, frontImgId = R.mipmap.ic_bg_life_front))
        cardImgList.add(CardImg(name = "百川归海", backImgId = R.mipmap.ic_bg_sea, frontImgId = R.mipmap.ic_bg_sea_front))
        cardImgList.add(CardImg(name = "烈日骄阳", backImgId = R.mipmap.ic_bg_sun, frontImgId = R.mipmap.ic_bg_sun_front))
        cardImgList.add(CardImg(name = "剑之荣耀", backImgId = R.mipmap.ic_bg_sword, frontImgId = R.mipmap.ic_bg_sword_front))
        cardImgList.add(CardImg(name = "魔兽之齿", backImgId = R.mipmap.ic_bg_teeth, frontImgId = R.mipmap.ic_bg_teeth_front))
        return cardImgList
    }

    // FIXME: 2017/9/6 by xw TODO: 换成CardImg
    /**
     * 获取背景
     */
    fun getBgResIdList(): MutableList<Int>? {
        val bgResList = ArrayList<Int>()
        getCardImgList()?.forEach {
            bgResList.add(it.backImgId)
        }
        return bgResList
    }

    /**
     * 获取背景Name
     */
    fun getBgResNameList(): MutableList<String>? {
        val bgResList = ArrayList<String>()
        bgResList.add("全部")
        getCardImgList()?.forEach {
            bgResList.add(it.name!!)
        }
        return bgResList
    }

    /**
     * 获取好友档案问题
     */
    fun getFriendRecords(isShuffle: Boolean, bgImgIndex: Int = -1): MutableList<Card>? {
        val cardList = ArrayList<Card>()
        Constant.VALUE_FRIEND_RECORD.forEachIndexed { index, value ->
            val card = Card()
            val cardImgList = getCardImgList()!!

            if (bgImgIndex == -1) {
                val randomNum = MathUtil.getRandomNum(cardImgList.size)
                card.backImgId = cardImgList[randomNum].backImgId
                card.frontImgId = cardImgList[randomNum].frontImgId
            } else {
                card.backImgId = cardImgList[bgImgIndex].backImgId
                card.frontImgId = cardImgList[bgImgIndex].frontImgId
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
     * 认识彼此的36个问题
     */
    fun getAmazing36Records(isShuffle: Boolean, bgImgIndex: Int = -1): MutableList<Card>? {
        val cardList = ArrayList<Card>()
        Constant.VALUE_AMAZING_36.forEachIndexed { index, value ->
            val card = Card()
            val cardImgList = getCardImgList()!!
            if (bgImgIndex == -1) {
                val randomNum = MathUtil.getRandomNum(cardImgList.size)
                card.backImgId = cardImgList[randomNum].backImgId
                card.frontImgId = cardImgList[randomNum].frontImgId
            } else {
                card.backImgId = cardImgList[bgImgIndex].backImgId
                card.frontImgId = cardImgList[bgImgIndex].frontImgId
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
     * 深入关系的50个问题
     */
    fun getDeep50Records(isShuffle: Boolean, bgImgIndex: Int = -1): MutableList<Card>? {
        val cardList = ArrayList<Card>()
        Constant.VALUE_DEEP_50.forEachIndexed { index, value ->
            val card = Card()
            val cardImgList = getCardImgList()!!
            if (bgImgIndex == -1) {
                val randomNum = MathUtil.getRandomNum(cardImgList.size)
                card.backImgId = cardImgList[randomNum].backImgId
                card.frontImgId = cardImgList[randomNum].frontImgId
            } else {
                card.backImgId = cardImgList[bgImgIndex].backImgId
                card.frontImgId = cardImgList[bgImgIndex].frontImgId
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
     * 突破关系的50个方案
     */
    fun getTodo50Records(isShuffle: Boolean, bgImgIndex: Int = -1): MutableList<Card>? {
        val cardList = ArrayList<Card>()
        Constant.VALUE_TODO_50.forEachIndexed { index, value ->
            val card = Card()
            val cardImgList = getCardImgList()!!
            if (bgImgIndex == -1) {
                val randomNum = MathUtil.getRandomNum(cardImgList.size)
                card.backImgId = cardImgList[randomNum].backImgId
                card.frontImgId = cardImgList[randomNum].frontImgId
            } else {
                card.backImgId = cardImgList[bgImgIndex].backImgId
                card.frontImgId = cardImgList[bgImgIndex].frontImgId
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