package com.app.simon.cardsgame

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.app.simon.base.BaseActivity

class AboutActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
    }

    companion object {
        private val TAG = AboutActivity::class.java.simpleName

        fun launch(activity: Activity) {
            val intent = Intent(activity, AboutActivity::class.java)
            activity.startActivity(intent)
        }
    }
}
