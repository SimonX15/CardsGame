package com.app.simon.base.util

import java.util.*

/**
 * desc:
 * date: 2017/8/8
 *
 * @author xw
 */

object MathUtil {
    /** 获取随机数 min-max */
    fun getRandomNum(min: Int, max: Int): Int {
        val random = Random()
        val s = random.nextInt(max) % (max - min + 1) + min
        return s
    }

    /** 获取随机数 0-max*/
    fun getRandomNum(max: Int): Int {
        val random = Math.random() * max
        return random.toInt()
    }
}

