package com.app.simon.base.method

import android.support.v4.widget.SwipeRefreshLayout

/**
 * desc:
 * date: 2017/8/9
 *
 * @author xw
 */
var SwipeRefreshLayout.postRefreshing: Boolean
    get() = isRefreshing
    set(value) {
        if (isRefreshing != value) {
            post {
                isRefreshing = value
            }
        }
    }
