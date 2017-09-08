package com.app.simon.cardsgame.question

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.app.simon.base.BaseActivity
import com.app.simon.base.callback.IViewCallBack
import com.app.simon.cardsgame.R
import com.app.simon.cardsgame.data.Constant
import com.app.simon.cardsgame.util.CardUtil
import kotlinx.android.synthetic.main.content_question_list.*

/**
 * desc: 问题列表
 * date: 2017/9/8
 *
 * @author xw
 */
class QuestionListActivity : BaseActivity(), IViewCallBack {

    /** 主题 */
    private var themeList: MutableList<String>? = null
    private var themeAdapter: ArrayAdapter<String>? = null

    /** 主题index */
    private var themeIndex = 0

    /** 问题 */
    private var cardList: MutableList<String>? = null
    private var cardAdapter: QuestionAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_list)

        initData()
        assignViews()
        refreshViews()
    }

    override fun initData() {
        themeIndex = THEME_DEFAULT
        themeList = CardUtil.getThemeList()

        refreshData(themeList!![themeIndex])
    }

    override fun assignViews() {
        themeAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, themeList)
        spinner_theme.adapter = themeAdapter
        spinner_theme.setSelection(themeIndex)
        spinner_theme.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                themeIndex = position
                refreshData(themeList!![position])
                refreshViews()
            }
        }

        //cardAdapter
        cardAdapter = QuestionAdapter(this, cardList!!)
        recycler_view.adapter = cardAdapter
    }

    override fun refreshViews() {
        cardAdapter!!.setNewData(cardList!!)
    }

    /**
     * 刷新数据
     */
    fun refreshData(value: String) {
        when (value) {
            Constant.THEME_KNOW_36 -> {
                cardList = Constant.VALUE_AMAZING_36.toMutableList()
            }
            Constant.THEME_FRIEND -> {
                cardList = Constant.VALUE_FRIEND_RECORD.toMutableList()
            }
            Constant.THEME_DEEP_50 -> {
                cardList = Constant.VALUE_DEEP_50.toMutableList()
            }
            Constant.THEME_TODO_50 -> {
                cardList = Constant.VALUE_TODO_50.toMutableList()
            }
            else -> {
                cardList = Constant.VALUE_AMAZING_36.toMutableList()
            }

        }
    }

    companion object {
        private val TAG = QuestionListActivity::class.java.simpleName

        private val THEME_DEFAULT = 0

        fun launch(activity: Activity) {
            val intent = Intent(activity, QuestionListActivity::class.java)
            activity.startActivity(intent)
        }
    }

}
