package com.lxt.monster.base

import android.app.ProgressDialog
import android.support.v4.app.Fragment

/**
 * desc: BaseFragment
 * date: 2017/8/15
 *
 * @author xw
 */

abstract class BaseFragment : Fragment() {
    /** Dialog */
    private var progressDialog: ProgressDialog? = null

    /**
     * show a progress dialog with the given message.
     */
    fun showProgressDialog(msg: String) {
        if (progressDialog == null) {
            progressDialog = ProgressDialog(activity)
        }
        progressDialog?.run {
            setMessage(msg)
            show()
        }
    }

    /**
     * show a progress dialog with the given message.
     */
    fun showProgressDialog(msg: String, cancelable: Boolean) {
        if (progressDialog == null) {
            progressDialog = ProgressDialog(activity)
            progressDialog?.run {
                setCancelable(cancelable)
                setCanceledOnTouchOutside(false)
            }
        }

        if (!progressDialog!!.isShowing) {
            progressDialog?.run {
                show()
                setMessage(msg)
            }
        }
    }

    /**
     * close a progress if there is one.
     */
    fun dismissProgressDialog() {
        if (progressDialog != null && progressDialog!!.isShowing) {
            progressDialog?.dismiss()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        progressDialog = null
    }
}