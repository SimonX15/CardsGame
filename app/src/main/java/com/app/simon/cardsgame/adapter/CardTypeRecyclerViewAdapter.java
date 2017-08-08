package com.app.simon.cardsgame.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.app.simon.base.widgets.RoundImageView;
import com.app.simon.cardsgame.R;
import com.app.simon.cardsgame.data.Constant;
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
        private RoundImageView img_card_back;
        private RoundImageView img_card_front;
        private TextView text_card_front_content;
        private TextView text_card_back_content;

        /** 是否正在显示正面，默认进来的时候，背面朝上 */
        private boolean isFrontShowing = false;

        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            this.frame_card_back = (FrameLayout) itemView.findViewById(R.id.frame_card_back);
            this.frame_card_front = (FrameLayout) itemView.findViewById(R.id.frame_card_front);
            this.img_card_back = (RoundImageView) itemView.findViewById(R.id.img_card_back);
            this.img_card_front = (RoundImageView) itemView.findViewById(R.id.img_card_front);
            this.text_card_front_content = (TextView) itemView.findViewById(R.id.text_card_front_content);
            this.text_card_back_content = (TextView) itemView.findViewById(R.id.text_card_back_content);
            // 设置镜头距离
            setCameraDistance(frame_card_front, frame_card_back);
        }

        private void bindViews(final Card card, int position) {
            if (card == null) {
                return;
            }

            // FIXME: 2017/8/8 by xw TODO: 产生bug的原因是alpha

            /*if (card.isFront()) {
                frame_card_front.setVisibility(View.VISIBLE);
                frame_card_back.setVisibility(View.INVISIBLE);
            } else {
                frame_card_front.setVisibility(View.INVISIBLE);
                frame_card_back.setVisibility(View.VISIBLE);
            }*/

            Log.i(TAG, "bindViews: position=" + position + "; frame_card_front=" + frame_card_front.getAlpha());
            Log.i(TAG, "bindViews: position=" + position + "; frame_card_back=" + frame_card_back.getAlpha());

            String type = card.getType();
            if (type != null) {
                if (type.equals(Constant.INSTANCE.getCARD_TYPE_FIRE())) {
                    img_card_back.setImageResource(R.mipmap.ic_type_fire);
                    img_card_front.setImageResource(R.mipmap.ic_type_default_front);
                } else if (type.equals(Constant.INSTANCE.getCARD_TYPE_SHIELD())) {
                    img_card_back.setImageResource(R.mipmap.ic_type_shield);
                    img_card_front.setImageResource(R.mipmap.ic_type_default_front);
                } else if (type.equals(Constant.INSTANCE.getCARD_TYPE_EAGLE())) {
                    img_card_back.setImageResource(R.mipmap.ic_type_eagle);
                    img_card_front.setImageResource(R.mipmap.ic_type_default_front);
                } else if (type.equals(Constant.INSTANCE.getCARD_TYPE_ICE())) {
                    img_card_back.setImageResource(R.mipmap.ic_type_ice);
                    img_card_front.setImageResource(R.mipmap.ic_type_default_front);
                } else if (type.equals(Constant.INSTANCE.getCARD_TYPE_RAINBOW())) {
                    img_card_back.setImageResource(R.mipmap.ic_type_rainbow);
                    img_card_front.setImageResource(R.mipmap.ic_type_default_front);
                } else if (type.equals(Constant.INSTANCE.getCARD_TYPE_CLOUD())) {
                    img_card_back.setImageResource(R.mipmap.ic_type_cloud);
                    img_card_front.setImageResource(R.mipmap.ic_type_default_front);
                } else if (type.equals(Constant.INSTANCE.getCARD_TYPE_GEM())) {
                    img_card_back.setImageResource(R.mipmap.ic_type_gem);
                    img_card_front.setImageResource(R.mipmap.ic_type_default_front);
                } else {
                    img_card_back.setImageResource(R.mipmap.ic_type_default);
                    img_card_front.setImageResource(R.mipmap.ic_type_default_front);
                }
            }

//            Log.i(TAG, "position=" + position + ";front=" + card.isFront());

            text_card_back_content.setText(card.getName());
            text_card_front_content.setText(card.getContent());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    frame_card_back.setVisibility(View.VISIBLE);
//                    frame_card_front.setVisibility(View.VISIBLE);
                    flipCard(frame_card_front, frame_card_back);
                    card.setFront(true);
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
            if (isFrontShowing) {
                //正面朝上：显示背面，隐藏正面
                AnimatorUtil.INSTANCE.setViewLeftInStart(backView);
                AnimatorUtil.INSTANCE.setViewRightOutStart(frontView, new AnimatorUtil.OnViewAnimatorListener() {
                    @Override
                    public void onAnimStart() {
                        itemView.setClickable(false);
                    }
                });

                isFrontShowing = true;
            } else {
                // 背面朝上： 隐藏背面，显示正面
                AnimatorUtil.INSTANCE.setViewLeftInStart(frontView);
                AnimatorUtil.INSTANCE.setViewRightOutStart(backView, new AnimatorUtil.OnViewAnimatorListener() {
                    @Override
                    public void onAnimStart() {
                        itemView.setClickable(false);
                    }
                });

                isFrontShowing = false;

            }
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
