package com.app.simon.base.util

import android.content.Context
import android.content.pm.PackageManager.NameNotFoundException

/**
 * 跟App相关的辅助类
 * Created by xw on 2016/8/3
 */
object AppUtil {

    /**
     * 获取应用程序名称
     */
    fun getAppName(context: Context): String? {
        try {
            val packageManager = context.packageManager
            val packageInfo = packageManager.getPackageInfo(context.packageName, 0)
            val labelRes = packageInfo.applicationInfo.labelRes
            return context.resources.getString(labelRes)
        } catch (e: NameNotFoundException) {
            e.printStackTrace()
        }
        return null
    }

    /**
     * 获取应用程序版本名称信息

     * @param context
     * *
     * @return 当前应用的版本名称
     */
    fun getVersionName(context: Context): String? {
        try {
            val packageManager = context.packageManager
            val packageInfo = packageManager.getPackageInfo(context.packageName, 0)
            return packageInfo.versionName
        } catch (e: NameNotFoundException) {
            e.printStackTrace()
        }
        return null
    }

    /**
     * 获取应用程序版本名称信息

     * @param context
     * *
     * @return 当前应用的版本名称
     */
    fun getVersionCode(context: Context): Int {
        try {
            val packageManager = context.packageManager
            val packageInfo = packageManager.getPackageInfo(context.packageName, 0)
            return packageInfo.versionCode
        } catch (e: NameNotFoundException) {
            e.printStackTrace()
        }
        return 0
    }

}
