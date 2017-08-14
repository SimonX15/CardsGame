package com.app.simon.cardsgame

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.app.simon.base.BaseActivity
import com.app.simon.base.callback.IViewCallBack

class StartActivity : BaseActivity(), IViewCallBack {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        initData()
        assignViews()
        refreshViews()
    }

    override fun initData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun assignViews() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun refreshViews() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        private val TAG = StartActivity::class.java.simpleName

        fun launch(activity: Activity) {
            val intent = Intent(activity, StartActivity::class.java)
            activity.startActivity(intent)
        }
    }
}
