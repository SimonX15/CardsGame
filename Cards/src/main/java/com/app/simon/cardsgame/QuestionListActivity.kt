package com.app.simon.cardsgame

import android.app.Activity
import android.content.Intent
import android.os.Bundle

import com.app.simon.base.BaseActivity

class QuestionListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_list)
    }

    companion object {
        private val TAG = QuestionListActivity::class.java.simpleName

        fun launch(activity: Activity) {
            val intent = Intent(activity, QuestionListActivity::class.java)
            activity.startActivity(intent)
        }
    }

}
