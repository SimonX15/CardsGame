package com.app.simon.cardsgame

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.app.simon.base.BaseActivity
import com.app.simon.base.callback.IViewCallBack

class GuideActivity : BaseActivity(), IViewCallBack {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide)

        initData()
        assignViews()
        refreshViews()
    }

    override fun initData() {
    }

    override fun assignViews() {
    }

    override fun refreshViews() {
    }

    companion object {
        private val TAG = GuideActivity::class.java.simpleName

        fun launch(activity: Activity) {
            val intent = Intent(activity, GuideActivity::class.java)
            activity.startActivity(intent)
        }
    }
}
