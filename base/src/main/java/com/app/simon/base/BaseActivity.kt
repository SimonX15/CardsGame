package com.app.simon.base

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem

/**
 * desc: BaseActivity
 * date: 2017/8/15
 *
 * @author xw
 */
abstract class BaseActivity : AppCompatActivity() {

    private var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }

    /**
     * show a progress dialog with the given message.
     */
    fun showProgressDialog(msg: String) {
        if (progressDialog == null) {
            progressDialog = ProgressDialog(this)
        }
        progressDialog!!.run {
            setMessage(msg)
            show()
        }
    }

    /**
     * show a progress dialog with the given message.
     */
    fun showProgressDialog(msg: String, cancelable: Boolean) {
        if (null == progressDialog) {
            progressDialog = ProgressDialog(this)
            progressDialog!!.run {
                setCancelable(cancelable)
                setCanceledOnTouchOutside(false)
            }
        }

        if (!progressDialog!!.isShowing) {
            if (!isFinishing) {
                progressDialog!!.run {
                    show()
                    setMessage(msg)
                }
            }
        }
    }

    /**
     * close a progress if there is one.
     */
    fun dismissProgressDialog() {
        if (progressDialog != null && progressDialog!!.isShowing) {
            progressDialog!!.dismiss()
        }
    }

}
