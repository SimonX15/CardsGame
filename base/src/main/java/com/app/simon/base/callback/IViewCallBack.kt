package com.app.simon.base.callback

/**
 * desc: View的基本操作
 * date: 2017/8/7
 *
 * @author xw
 */
interface IViewCallBack {

    /**
     * 获取初始数据
     */
    fun initData()

    /**
     * 绑定控件
     */
    fun assignViews()

    /**
     * 刷新数据
     */
    fun refreshViews()
}
