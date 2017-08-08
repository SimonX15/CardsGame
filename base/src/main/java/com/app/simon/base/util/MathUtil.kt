package com.app.simon.base.util

import java.util.*

/**
 * desc:
 * date: 2017/8/8
 *
 * @author xw
 */

object MathUtil {
    /** 获取随机数 */
    fun getRandomNum(min: Int, max: Int): Int {
        val random = Random()
        val s = random.nextInt(max) % (max - min + 1) + min
        return s
    }
}

