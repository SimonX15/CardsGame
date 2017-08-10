package com.app.simon.cardsgame

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.app.simon.base.BaseActivity
import com.app.simon.base.callback.IViewCallBack
import com.app.simon.base.util.AppUtil
import kotlinx.android.synthetic.main.activity_about.*
import kotlinx.android.synthetic.main.content_about.*

class AboutActivity : BaseActivity(), IViewCallBack {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        initData()
        assignViews()
        refreshViews()
    }

    override fun initData() {
    }

    override fun assignViews() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        text_version.text = "v" + AppUtil.getVersionName(this)
    }

    override fun refreshViews() {
    }

    companion object {
        private val TAG = AboutActivity::class.java.simpleName

        fun launch(activity: Activity) {
            val intent = Intent(activity, AboutActivity::class.java)
            activity.startActivity(intent)
        }
    }
}
