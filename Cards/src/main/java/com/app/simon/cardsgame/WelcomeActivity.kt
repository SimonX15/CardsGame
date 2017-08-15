package com.app.simon.cardsgame

import android.os.Bundle
import com.app.simon.base.BaseActivity
import com.app.simon.base.callback.IViewCallBack
import com.app.simon.base.util.AppUtil
import com.app.simon.base.util.SharedPreferencesUtil
import kotlinx.android.synthetic.main.activity_welcome.*

/**
 * desc: Welcome
 * date: 2017/8/14
 *
 * @author xw
 */
class WelcomeActivity : BaseActivity(), IViewCallBack {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        initData()
        assignViews()
        refreshViews()
    }

    override fun initData() {

    }

    override fun assignViews() {
        if (isShowGuide()) {
            GuideActivity.launch(this)
            finish()
        } else {
            iv_welcome.postDelayed({
                MainActivity.launch(this)
                finish()
            }, DELAY_MILLIS.toLong())
        }

    }

    override fun refreshViews() {

    }

    /**
     * 是否显示引导页
     */
    private fun isShowGuide(): Boolean {
        //获取版本信息
        val oldVersionCode: Int = SharedPreferencesUtil.get(this, SharedPreferencesUtil.PREF_OLD_VERSION, 0) as Int
        val currentVersionCode: Int = AppUtil.getVersionCode(this)
        //比较
        if (oldVersionCode != currentVersionCode) {
            SharedPreferencesUtil.put(this, SharedPreferencesUtil.PREF_OLD_VERSION, currentVersionCode)
        }
        return currentVersionCode > oldVersionCode
    }

    companion object {
        /** 延迟时间 */
        private val DELAY_MILLIS = 2000
    }
}
