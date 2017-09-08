package com.app.simon.cardsgame.about

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.app.simon.base.BaseActivity
import com.app.simon.base.callback.IViewCallBack
import com.app.simon.base.util.AppUtil
import com.app.simon.cardsgame.R
import com.app.simon.cardsgame.question.QuestionListActivity
import com.lxt.base.util.SharePreferenceUtil
import kotlinx.android.synthetic.main.activity_about.*
import kotlinx.android.synthetic.main.content_about.*
import org.jetbrains.anko.toast

/**
 * desc: 关于
 * date: 2017/8/15
 *
 * @author xw
 */
class AboutActivity : BaseActivity(), IViewCallBack {

    /** 点击次数 */
    var pressTimes = 0

    /** 是否跳转列表页 */
    var isShowList = false

    /** 显示一次toast */
    var isFirstToast = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        initData()
        assignViews()
        refreshViews()
    }

    override fun initData() {
        isShowList = SharePreferenceUtil.get(this, SharePreferenceUtil.PREF_SHOW_LIST, false)
    }

    override fun assignViews() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        text_version.text = "v" + AppUtil.getVersionName(this)

        text_develop.setOnClickListener {
            when (isShowList) {
                true -> {
                    QuestionListActivity.launch(this)
                }
                else -> {
                    if (isFirstToast) {
                        toast("点击 $PRESS_TIMES_MAX 次后，开启隐藏页面")
                    }
                    pressTimes++
                    if (pressTimes >= PRESS_TIMES_MAX) {
                        //缓存
                        SharePreferenceUtil.put(this, SharePreferenceUtil.PREF_SHOW_LIST, true)
                        //跳转
                        QuestionListActivity.launch(this)
                    }
                }
            }
        }
    }

    override fun refreshViews() {
    }

    companion object {
        private val TAG = AboutActivity::class.java.simpleName

        /** 点击最大次数 */
        val PRESS_TIMES_MAX = 7

        fun launch(activity: Activity) {
            val intent = Intent(activity, AboutActivity::class.java)
            activity.startActivity(intent)
        }
    }
}
