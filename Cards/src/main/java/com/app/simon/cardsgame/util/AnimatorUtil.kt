package com.app.simon.cardsgame.util

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.View

/**
 * desc: Animator Util
 * date: 2017/8/8

 * @author xw
 */
object AnimatorUtil {

    /**
     * 显示（旋转+透明度）

     * @param view
     */
    fun setViewLeftInStart(view: View) {
        val animatorSet = AnimatorSet()
        //旋转
        val rotationAnimator = ObjectAnimator.ofFloat(view, "rotationY", -180f, 0f)
        rotationAnimator.duration = 2000
        //        rotationAnimator.setInterpolator(new LinearInterpolator());

        //透明度
        val alphaAnimator = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f)
        alphaAnimator.duration = 1000
        //        rotationAnimator.setInterpolator(new LinearInterpolator());

        //同时开始
        animatorSet.playTogether(rotationAnimator, alphaAnimator)
        animatorSet.start()
    }

    /**
     * 隐藏（旋转+透明度）

     * @param view
     * *
     * @param listener
     */
    fun setViewRightOutStart(view: View, listener: OnViewAnimatorListener?) {
        val animatorSet = AnimatorSet()
        //旋转
        val rotationAnimator = ObjectAnimator.ofFloat(view, "rotationY", 0f, 180f)
        rotationAnimator.duration = 2000
        //        rotationAnimator.setInterpolator(new LinearInterpolator());

        //透明度
        val alphaAnimator = ObjectAnimator.ofFloat(view, "alpha", 1f, 0f)
        alphaAnimator.startDelay = 1000
        alphaAnimator.duration = 0
        //        rotationAnimator.setInterpolator(new LinearInterpolator());

        animatorSet.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator) {
                super.onAnimationStart(animation)
                listener?.onAnimStart()
            }
        })

        //同时开始
        animatorSet.playTogether(rotationAnimator, alphaAnimator)
        animatorSet.start()
    }


    interface OnViewAnimatorListener {
        fun onAnimStart()
    }
}
