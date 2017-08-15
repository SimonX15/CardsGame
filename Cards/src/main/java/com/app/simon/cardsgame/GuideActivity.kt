package com.app.simon.cardsgame

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import com.app.simon.base.BaseActivity
import com.app.simon.base.callback.IViewCallBack
import kotlinx.android.synthetic.main.activity_guide.*

/**
 * desc: 引导页
 * date: 2017/8/15
 *
 * @author xw
 */
class GuideActivity : BaseActivity(), IViewCallBack {

    private val resIds = intArrayOf(R.mipmap.guide_1, R.mipmap.guide_2, R.mipmap.guide_3, R.mipmap.guide_4, R.mipmap.guide_5)

    lateinit var adapter: PageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_guide)

        initData()
        assignViews()
        refreshViews()
    }

    override fun initData() {
        adapter = PageAdapter(supportFragmentManager)
    }

    override fun assignViews() {
        setGuideAtLastPage(false)
        view_pager.adapter = adapter
        view_pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {
                //滑动到最后一页时的处理
                if (position == adapter.count - 1) {
                    setGuideAtLastPage(true)
                } else {
                    setGuideAtLastPage(false)
                }
            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })
        circle_page_indicator.setViewPager(view_pager)

        btn_skip.setOnClickListener {
            toMainActivity()
        }

        btn_start.setOnClickListener {
            toMainActivity()
        }
    }

    /** 去主页 */
    private fun toMainActivity() {
        MainActivity.launch(this)
        finish()
    }

    /**
     * 是否在最后一张引导页
     */
    private fun setGuideAtLastPage(isLastPage: Boolean) {
        if (isLastPage) {
            btn_skip.visibility = View.INVISIBLE
            btn_start.visibility = View.VISIBLE
        } else {
            btn_skip.visibility = View.VISIBLE
            btn_start.visibility = View.INVISIBLE
        }
    }

    override fun refreshViews() {
    }

    companion object {
        private val TAG = GuideActivity::class.java.simpleName

        fun launch(activity: Activity) {
            val intent = Intent(activity, GuideActivity::class.java)
            activity.startActivity(intent)
        }
    }


    inner class PageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return PageFragment.newInstance(resIds[position])
        }

        override fun getCount(): Int {
            return resIds.size
        }
    }

    class PageFragment : Fragment() {
        private var resId: Int = 0

        override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            val ivGuide = ImageView(activity)
            ivGuide.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
            ivGuide.scaleType = ImageView.ScaleType.CENTER_CROP
            ivGuide.setImageResource(resId)
            return ivGuide
        }

        companion object {
            fun newInstance(resId: Int): PageFragment {
                val fragment = PageFragment()
                fragment.resId = resId
                return fragment
            }
        }
    }
}
