package com.app.simon.cardsgame.data

import com.app.simon.cardsgame.R

/**
 * desc: Constant
 * date: 2017/8/8

 * @author xw
 */
object Constant {

//    val CARD_BG_DEFAULT = "CARD_BG_DEFAULT"
//    val CARD_BG_FIRE = "CARD_BG_FIRE"
//    val CARD_BG_EAGLE = "CARD_BG_EAGLE"
//    val CARD_BG_ICE = "CARD_BG_ICE"
//    val CARD_BG_RAINBOW = "CARD_BG_RAINBOW"
//    val CARD_BG_GEM = "CARD_BG_GEM"
//    val CARD_BG_CRYSTAL = "CARD_BG_CRYSTAL"
//    val CARD_BG_FEATHER = "CARD_BG_FEATHER"
//    val CARD_BG_GOLDEN = "CARD_BG_GOLDEN"
//    val CARD_BG_GOLD = "CARD_BG_GOLD"
//    val CARD_BG_LIFE = "CARD_BG_LIFE"
//    val CARD_BG_SEA = "CARD_BG_SEA"
//    val CARD_BG_SUN = "CARD_BG_SUN"
//    val CARD_BG_SWORD = "CARD_BG_SWORD"
//    val CARD_BG_TEETH = "CARD_BG_TEETH"

    /** 卡片背景 */
    val CARD_BG_STR = arrayOf("全部", "默认", "火焰之歌", "雄鹰展翅", "彩虹之约", "冰雪奇缘", "炫彩宝石",
            "媚惑水晶", "胜利之羽", "金之术士", "金色灿烂", "生命赞歌", "百川归海", "烈日骄阳", "剑之荣耀", "魔兽之齿")

    /** 卡片背景 */
    val CARD_BG = arrayOf(R.mipmap.ic_bg_default, R.mipmap.ic_bg_fire, R.mipmap.ic_bg_eagle, R.mipmap.ic_bg_rainbow,
            R.mipmap.ic_bg_ice, R.mipmap.ic_bg_gem, R.mipmap.ic_bg_crystal, R.mipmap.ic_bg_feather, R.mipmap.ic_bg_gold,
            R.mipmap.ic_bg_golden, R.mipmap.ic_bg_life, R.mipmap.ic_bg_sea, R.mipmap.ic_bg_sun, R.mipmap.ic_bg_sword,
            R.mipmap.ic_bg_teeth)
    /** 卡片背景 */
    val CARD_BG_FRONT = arrayOf(R.mipmap.ic_bg_default_front, R.mipmap.ic_bg_fire_front, R.mipmap.ic_bg_eagle_front,
            R.mipmap.ic_bg_rainbow_front, R.mipmap.ic_bg_ice_front, R.mipmap.ic_bg_gem_front, R.mipmap.ic_bg_crystal_front,
            R.mipmap.ic_bg_feather_front, R.mipmap.ic_bg_gold_front, R.mipmap.ic_bg_golden_front, R.mipmap.ic_bg_life_front,
            R.mipmap.ic_bg_sea_front, R.mipmap.ic_bg_sun_front, R.mipmap.ic_bg_sword_front, R.mipmap.ic_bg_teeth_front)

    /** 角色  */
    val KEY_ROLE = arrayOf("自己", "挚友", "战友", "亲人", "师傅", "爱人")

    /** 主题 */
    val THEME_36 = "认识彼此的简答问题"
    val THEME_FRIEND = "好友档案"

    /** 主题  */
    val KEY_THEME = arrayOf(THEME_36, THEME_FRIEND)


    /** 问题，好友档案  */
    val VALUE_FRIEND_RECORD = arrayOf(
            "家庭组成是怎样的？关系怎么样呢？",
            "喜欢什么运动？",
            "喜欢什么颜色？",
            "喜欢什么类型的衣服？",
            "喜欢收到什么类型的礼物？",
            "喜欢什么花？",
            "喜欢吃什么水果？",
            "喜欢吃什么零食？",
            "喜欢什么类型的音乐？",
            "看不惯男生的哪些言行举止？",
            "看不惯女生的哪些言行举止？",
            "爱的语言？",
            "容易被激励到的方式？",
            "伤心难过时别人怎样做让你觉得被爱？",
            "关系里最看重的是什么？",
            "关系里最害怕的是什么？",
            "面对冲突和压力你的反应通常是什么？",
            "你的情绪按钮是什么？",
            "最欣赏自己的部分有哪些？",
            "做X后改变比较大的有哪些？",
            "清晰自己需要成长的部分有哪些？",
            "对自己属灵程度的评价是怎样的？",
            "目前有没有那些部分是很困惑你的？",
            "圣经里特别喜欢的人物？",
            "你欣赏的异性的特质有哪些？",
            "你心目中最美好的场景是怎样的或者你一直想做的事情？")

    /** 认识彼此的简答问题  */
    val VALUE_AMAZING_36 = arrayOf(
            "假如可以选择世界上任何人，你希望邀请谁共进一餐？",
            "你希望成名吗？在哪一方面？",
            "拨打电话前，你会先练习要说的话吗？为什么？",
            "对你来说，怎样才算是“完美”的一天？",
            "上一次唱歌给自己听是什么时候？唱歌给别人听又是什么时候呢？",
            "你愿意能够活到90岁，但你的心智一直停留在30岁吗？",
            "列举3个你和对方共同拥有的特质。",
            "你的人生中最感恩的事情是什么？",
            "假如可以改变你成长过程中的任何事，你希望有哪些改变？",
            "假如明天早上起床后能获得任何一种能力或特质，你希望是什么？",
            "假如有颗水晶球能告诉你关于自己、人生或未来的一切真相，你想知道什么？",
            "有什么事想做很久了？还没去做的原因是？",
            "你人生最大的成就是什么？",
            "友情中你最重视哪一个部份？",
            "你最珍贵的回忆是什么？",
            "你最糟糕的回忆是什么？",
            "如果你知道自己将在一年内突然死去，你会改变自己目前的生活方式吗？为什么？",
            "友情对你而言意味着什么？",

            "爱和感情在你生命里扮演什么样的角色？",
            "分享你认为对方拥有的比较好的性格特点。",
            "你的家庭关系亲密温暖吗？你是否觉得自己的童年比大部分人快乐？",
            "你与母亲的关系如何？",
            "说出3个含有“我们”并且符合实际情况的句子，比如“我们现在都在这个群里”。",
            "完成这个句子：“我希望可以跟某个人分享：”。",
            "如果你要成为对方的好友，有什么事是他或她需要知道的？",
            "告诉对方你欣赏他或她的什么地方？",
            "和对方分享你人生中尴尬的时刻。",
            "上次在别人面前哭是什么时候？自己哭又是什么时候？",
            "告诉对方，你现在欣赏他或她什么地方。",
            "有什么事是绝对不能开玩笑的？",
            "如果你今天晚上就会死掉，而且无法与任何人联系，你最遗憾还没有告诉别人什么事？为什么还没说呢？",
            "你的房子起火了，你所有的东西都在里面。在救出所爱的人和宠物后，你还有时间可以安全地抢救出最后一件东西。你会拿什么？为什么？",
            "分享你人生中的一个问题，问对方遇到这样的问题会怎么做。同时也请对方告诉你，在他或她看来，你对这个问题的感受是什么。")


}
