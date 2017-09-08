package com.app.simon.cardsgame.welcome

import android.os.Bundle
import com.app.simon.base.BaseActivity
import com.app.simon.base.callback.IViewCallBack
import com.app.simon.base.util.AppUtil
import com.app.simon.cardsgame.main.MainActivity
import com.app.simon.cardsgame.R
import com.lxt.base.util.SharePreferenceUtil
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
        val oldVersionCode: Int = SharePreferenceUtil.get(this, SharePreferenceUtil.PREF_OLD_VERSION, 0)
        val currentVersionCode: Int = AppUtil.getVersionCode(this)
        //比较
        if (oldVersionCode != currentVersionCode) {
            SharePreferenceUtil.put(this, SharePreferenceUtil.PREF_OLD_VERSION, currentVersionCode)
        }
        return currentVersionCode > oldVersionCode
    }

    companion object {
        /** 延迟时间 */
        private val DELAY_MILLIS = 2000
    }
}
