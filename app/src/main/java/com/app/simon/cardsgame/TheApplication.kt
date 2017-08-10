package com.app.simon.cardsgame

import android.app.Application

/**
 * desc: TheApplication
 * date: 2017/8/10
 *
 * @author xw
 */
class TheApplication : Application() {

    companion object {
        /** 是否乱序排列，默认乱序 */
        var isShuffle = true

    }
}