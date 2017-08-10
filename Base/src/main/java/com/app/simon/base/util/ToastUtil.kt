package com.app.simon.base.util

import android.content.Context
import android.widget.Toast

/**
 * Toast统一管理类
 * Created by xw on 2016/8/3.
 */
object ToastUtil {

    private val isShow = true

    /**
     * 短时间显示Toast

     * @param context
     * *
     * @param message
     */
    fun showShort(context: Context, message: CharSequence) {
        if (isShow)
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    /**
     * 长时间显示Toast

     * @param context
     * *
     * @param message
     */
    fun showLong(context: Context, message: CharSequence) {
        if (isShow)
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    /**
     * 自定义显示Toast时间

     * @param context
     * *
     * @param message
     * *
     * @param duration
     */
    fun show(context: Context, message: CharSequence, duration: Int) {
        if (isShow)
            Toast.makeText(context, message, duration).show()
    }

}