package com.app.simon.cardsgame.questionlist

import android.content.Context
import android.widget.TextView
import com.app.simon.cardsgame.R
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * desc: QuestionAdapter
 * date: 2017/8/23
 *
 * @author xw
 */
class QuestionAdapter(context: Context, data: MutableList<String>) : BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_question, data) {

    val context: Context? = context

    override fun convert(helper: BaseViewHolder?, item: String?) {
        if (item == null) {
            return
        }

        val tv_question: TextView? = helper?.getView<TextView>(R.id.tv_question)
        tv_question?.text = item
    }
}