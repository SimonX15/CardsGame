package com.lxt.base.util

import android.content.Context
import android.content.SharedPreferences

/**
 * desc: SharePreferenceUtil
 * date: 2017/8/16

 * @author xw
 */
object SharePreferenceUtil {
    private val DEFAULT_PREF_FILE_NAME = "DEFAULT_PREF_FILE_NAME"
    private var sharedPreferences: SharedPreferences? = null

    /** 旧版本号  */
    val PREF_OLD_VERSION = "PREF_OLD_VERSION"

    /** 是否开启列表页面  */
    val PREF_SHOW_LIST = "PREF_SHOW_LIST"

    /**
     * Set a String value in the preferences.
     */
    fun put(context: Context, key: String, value: String) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(DEFAULT_PREF_FILE_NAME, Context.MODE_PRIVATE)
        }
        sharedPreferences!!.edit().putString(key, value).apply()
    }

    /**
     * Set a String value in the preferences.
     */
    fun put(context: Context, key: String, value: Boolean) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(DEFAULT_PREF_FILE_NAME, Context.MODE_PRIVATE)
        }
        sharedPreferences!!.edit().putBoolean(key, value).apply()
    }

    fun put(context: Context, key: String, value: Int) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(DEFAULT_PREF_FILE_NAME, Context.MODE_PRIVATE)
        }
        sharedPreferences!!.edit().putInt(key, value).apply()
    }

    fun put(context: Context, key: String, value: Long) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(DEFAULT_PREF_FILE_NAME, Context.MODE_PRIVATE)
        }
        sharedPreferences!!.edit().putLong(key, value).apply()
    }

    /**
     * Retrieve a String value from the preferences.The default value is a empty string.
     */
    operator fun get(context: Context, key: String): String {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(DEFAULT_PREF_FILE_NAME, Context.MODE_PRIVATE)
        }
        return sharedPreferences!!.getString(key, "")
    }

    /**
     * Retrieve a String value from the preferences.The default value is a empty string.
     */
    fun get(context: Context, key: String, defaultValue: Boolean): Boolean {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(DEFAULT_PREF_FILE_NAME, Context.MODE_PRIVATE)
        }
        return sharedPreferences!!.getBoolean(key, defaultValue)
    }

    /**
     * Retrieve a String value from the preferences.The default value is a empty string.
     */
    fun get(context: Context, key: String, defaultValue: Int): Int {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(DEFAULT_PREF_FILE_NAME, Context.MODE_PRIVATE)
        }
        return sharedPreferences!!.getInt(key, defaultValue)
    }

    fun get(context: Context, key: String, defaultValue: Long): Long {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(DEFAULT_PREF_FILE_NAME, Context.MODE_PRIVATE)
        }
        return sharedPreferences!!.getLong(key, defaultValue)
    }

    /**
     * Remove the preference value.
     */
    fun remove(context: Context, key: String) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(DEFAULT_PREF_FILE_NAME, Context.MODE_PRIVATE)
        }
        sharedPreferences!!.edit().remove(key).apply()
    }
}
