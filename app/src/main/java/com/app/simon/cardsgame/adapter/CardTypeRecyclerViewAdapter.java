package com.app.simon.cardsgame.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.app.simon.cardsgame.R;
import com.app.simon.cardsgame.models.Card;
import com.app.simon.cardsgame.util.AnimatorUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * desc：卡片类型适配器
 * author：simon
 * date：2017/2/16
 */
public class CardTypeRecyclerViewAdapter extends RecyclerView.Adapter<CardTypeRecyclerViewAdapter.ViewHolder> {
    public static String TAG = CardTypeRecyclerViewAdapter.class.getSimpleName();

    private Context context;
    private List<Card> cardTypeList;
    private OnCardTypeItemClickListener onCardTypeItemClickListener;

    public CardTypeRecyclerViewAdapter(Context context) {
        this.context = context;
        if (cardTypeList == null) {
            cardTypeList = new ArrayList<>();
        }
    }

    /**--------------数据处理----------------------*/
    /**
     * 添加List
     *
     * @param items
     */
    public void addItems(List<Card> items) {
        int index = cardTypeList.size();
        cardTypeList.addAll(index, items);
        notifyItemChanged(index);
    }

    /**
     * 添加一个
     *
     * @param item
     */
    public void addItem(Card item) {
        cardTypeList.add(item);
        notifyItemInserted(cardTypeList.size());
    }

    /**
     * 清除
     */
    public void clear() {
        cardTypeList.clear();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_card_type, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindViews(cardTypeList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return cardTypeList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private View itemView;
        private FrameLayout frame_card_back;
        private FrameLayout frame_card_front;
        private TextView text_card_front_content;
        private TextView text_card_back_content;

        /** 右出动画 */
//        private AnimatorSet mRightOutSet;
        /** 左入动画 */
//        private AnimatorSet mLeftInSet;

        /** 是否显示背面 */
        private boolean isBackShowing = false;

        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            this.frame_card_back = (FrameLayout) itemView.findViewById(R.id.frame_card_back);
            this.frame_card_front = (FrameLayout) itemView.findViewById(R.id.frame_card_front);
            this.text_card_front_content = (TextView) itemView.findViewById(R.id.text_card_front_content);
            this.text_card_back_content = (TextView) itemView.findViewById(R.id.text_card_back_content);
            // 设置动画
            setAnimators(itemView);
            // 设置镜头距离
            setCameraDistance(frame_card_front, frame_card_back);
        }

        private void bindViews(final Card cardType, int position) {
            text_card_front_content.setText(cardType.getTypeName());
            text_card_back_content.setText(cardType.getTypeName() + "F");

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*if (onCardTypeItemClickListener != null) {
                        onCardTypeItemClickListener.onItemClick();
                    }*/
                    frame_card_back.setVisibility(View.VISIBLE);
                    frame_card_front.setVisibility(View.VISIBLE);
                    flipCard(frame_card_front, frame_card_back);
                    cardType.setBack(true);
                }
            });
        }

        /**
         * 翻转卡片
         *
         * @param frontView
         * @param backView
         */
        private void flipCard(View frontView, View backView) {
            // 正面朝上
            if (!isBackShowing) {
                //显示背面，隐藏正面
                AnimatorUtil.INSTANCE.setViewLeftInStart(backView);
                AnimatorUtil.INSTANCE.setViewRightOutStart(frontView, new AnimatorUtil.OnViewAnimatorListener() {
                    @Override
                    public void onAnimStart() {
                        itemView.setClickable(false);
                    }
                });
//                mLeftInSet.setTarget(backView);
//                mLeftInSet.start();

//                mRightOutSet.setTarget(frontView);
//                mRightOutSet.start();

                isBackShowing = true;
            } else {
                // 背面朝上： 隐藏背面，显示正面
                AnimatorUtil.INSTANCE.setViewLeftInStart(frontView);
                AnimatorUtil.INSTANCE.setViewRightOutStart(backView, new AnimatorUtil.OnViewAnimatorListener() {
                    @Override
                    public void onAnimStart() {
                        itemView.setClickable(false);
                    }
                });

//                mLeftInSet.setTarget(frontView);
//                mLeftInSet.start();

//                mRightOutSet.setTarget(backView);
//                mRightOutSet.start();

                isBackShowing = false;
            }
        }

        // 设置动画
        private void setAnimators(final View view) {
//            mLeftInSet = (AnimatorSet) AnimatorInflater.loadAnimator(context, R.animator.anim_in);
//            mRightOutSet = (AnimatorSet) AnimatorInflater.loadAnimator(context, R.animator.anim_out);

            // 设置点击事件
            /*mLeftInSet.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    //                  itemView.setClickable(true);
                }
            });
            mRightOutSet.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationStart(Animator animation) {
                    super.onAnimationStart(animation);
                    view.setClickable(false);
                }
            });*/
        }

        // 改变视角距离, 贴近屏幕
        private void setCameraDistance(View front, View back) {
            int distance = 16000;
            float scale = context.getResources().getDisplayMetrics().density * distance;
            front.setCameraDistance(scale);
            back.setCameraDistance(scale);
        }
    }

    public interface OnCardTypeItemClickListener {
        void onItemClick();
    }

    public void setOnCardTypeItemClickListener(OnCardTypeItemClickListener onCardTypeItemClickListener) {
        this.onCardTypeItemClickListener = onCardTypeItemClickListener;
    }
}
