package com.app.simon.cardsgame.main.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import com.app.simon.base.widgets.RoundImageView
import com.app.simon.cardsgame.R
import com.app.simon.cardsgame.main.models.Card
import com.app.simon.cardsgame.util.AnimatorUtil
import java.util.*


/**
 * desc: 卡片适配器
 * date: 2017/8/9
 *
 * @author xw
 */
class CardRecyclerViewAdapter(private val context: Context) : RecyclerView.Adapter<CardRecyclerViewAdapter.CardItemViewHolder>() {
    private var cardList: MutableList<Card>? = null
    private var onCardItemClickListener: OnCardItemClickListener? = null

    init {
        if (cardList == null) {
            cardList = ArrayList<Card>()
        }
    }

    /** --------------------------数据处理-------------------------- */
    /**
     * 添加List

     * @param items
     */
    fun addItems(items: List<Card>) {
        val index = cardList!!.size
        cardList!!.addAll(index, items)
        notifyItemChanged(index)
    }

    /**
     * 添加一个

     * @param item
     */
    fun addItem(item: Card) {
        cardList!!.add(item)
        notifyItemInserted(cardList!!.size)
    }

    /**
     * 返回cardList
     */
    fun getItems(): MutableList<Card>? {
        return cardList
    }

    /**
     * 清除
     */
    fun clear() {
        cardList!!.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardItemViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_card_type, parent, false)
        return CardItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardItemViewHolder, position: Int) {
        holder.bindViews(cardList!![position], position)
    }

    override fun getItemCount(): Int {
        return cardList!!.size
    }

    /** --------------------------ViewHolder-------------------------- */
    inner class CardItemViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        private val frame_card_back: FrameLayout
        private val frame_card_front: FrameLayout
        private val img_card_back: RoundImageView
        private val img_card_front: RoundImageView
        private val text_card_front_content: TextView
        private val text_card_back_content: TextView

        /** 是否正在显示正面，默认进来的时候，背面朝上  */
        private var isFrontShowing = false

        init {
            this.frame_card_back = itemView?.findViewById(R.id.frame_card_back) as FrameLayout
            this.frame_card_front = itemView.findViewById(R.id.frame_card_front) as FrameLayout
            this.img_card_back = itemView.findViewById(R.id.img_card_back) as RoundImageView
            this.img_card_front = itemView.findViewById(R.id.img_card_front) as RoundImageView
            this.text_card_front_content = itemView.findViewById(R.id.text_card_front_content) as TextView
            this.text_card_back_content = itemView.findViewById(R.id.text_card_back_content) as TextView
            // 设置镜头距离
            setCameraDistance(frame_card_front, frame_card_back)
        }

        /** 绑定views */
        fun bindViews(card: Card, position: Int) {

            if (card.backImgId != 0) {
                img_card_back.setImageResource(card.backImgId)
            } else {
                img_card_back.setImageResource(R.mipmap.ic_bg_default)
            }

            if (card.frontImgId != 0) {
                img_card_front.setImageResource(card.frontImgId)
            } else {
                img_card_front.setImageResource(R.mipmap.ic_bg_default_front)
            }

//            text_card_back_content.text = card.name
            text_card_front_content.text = card.content

            //Add by xw at 2017/8/9：因为有动画效果，所有重新加载的时候，alpha和rotationY会重置，需要再次设置一下
            if (card.isFront) {
                setViewStatus(frame_card_front, true)
                setViewStatus(frame_card_back, false)
            } else {
                setViewStatus(frame_card_front, false)
                setViewStatus(frame_card_back, true)
            }

//            LogUtil.i(TAG, "position=" + position + ";frame_card_front.alpha=" + frame_card_front.alpha)
//            LogUtil.i(TAG, "position=" + position + ";frame_card_back.alpha=" + frame_card_back.alpha)
//            LogUtil.i(TAG, "position=" + position + ";frame_card_front.rotationY=" + frame_card_front.rotationY)
//            LogUtil.i(TAG, "position=" + position + ";frame_card_back.rotationY=" + frame_card_back.rotationY)

            itemView.setOnClickListener {
                flipCard(frame_card_front, frame_card_back)
                card.isFront = true
            }
        }

        private fun setViewStatus(view: View, isShow: Boolean) {
            if (isShow) {
                view.alpha = 1f
                view.rotationY = 0f
            } else {
                view.alpha = 0f
                view.rotationY = 180f
            }
        }

        /**
         * 翻转卡片

         * @param frontView
         * *
         * @param backView
         */
        private fun flipCard(frontView: View, backView: View) {
            if (isFrontShowing) {
                //正面朝上：显示背面，隐藏正面
                AnimatorUtil.setViewLeftInStart(backView)
                AnimatorUtil.setViewRightOutStart(frontView, object : AnimatorUtil.OnViewAnimatorListener {
                    override fun onAnimStart() {
                        itemView.isClickable = false
                    }
                })

                isFrontShowing = true
            } else {
                // 背面朝上： 隐藏背面，显示正面
                AnimatorUtil.setViewLeftInStart(frontView)
                AnimatorUtil.setViewRightOutStart(backView, object : AnimatorUtil.OnViewAnimatorListener {
                    override fun onAnimStart() {
                        itemView.isClickable = false
                    }
                })

                isFrontShowing = false

            }
        }

        /**
         * 改变视角距离, 贴近屏幕
         */
        private fun setCameraDistance(front: View, back: View) {
            val distance = 16000
            val scale = context.resources.displayMetrics.density * distance
            front.cameraDistance = scale
            back.cameraDistance = scale
        }
    }


    /** --------------------------listener-------------------------- */
    interface OnCardItemClickListener {
        fun onItemClick()
    }

    fun setOnCardTypeItemClickListener(onCardItemClickListener: OnCardItemClickListener) {
        this.onCardItemClickListener = onCardItemClickListener
    }

    companion object {
        var TAG = CardRecyclerViewAdapter::class.java.simpleName
    }

}
