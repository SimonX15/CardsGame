package com.app.simon.cardsgame

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import com.app.simon.base.BaseActivity
import com.app.simon.base.callback.IViewCallBack
import com.app.simon.base.util.LogUtil
import com.app.simon.base.util.postRefreshing
import com.app.simon.cardsgame.adapter.CardRecyclerViewAdapter
import com.app.simon.cardsgame.data.Constant
import com.app.simon.cardsgame.models.Card
import com.app.simon.cardsgame.util.CardUtil
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.jetbrains.anko.toast
import java.util.*


class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener, IViewCallBack {

    private val THEME_DEFAULT = 0
    private val BG_DEFAULT = 0

    /** 问题 */
    private var cardList: MutableList<Card>? = null
    private var cardAdapter: CardRecyclerViewAdapter? = null

    /** 主题 */
    private var themeList: MutableList<String>? = null
    private var themeAdapter: ArrayAdapter<String>? = null

    /** 背景 */
    private var bgList: MutableList<Int>? = null
    private var bgNameList: MutableList<String>? = null
    private var bgAdapter: ArrayAdapter<String>? = null

    /** 主题index */
    private var themeIndex = 0
    /** 背景色index */
    private var bgIndex = 0
    /** 是否乱序排列 */
    private var isShuffle = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
        assignViews()
        refreshViews()
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            val time = Calendar.getInstance().time.time
            if (time - lastBackPressTime > 2000L) {
                lastBackPressTime = time
                toast("再按一次退出程序")
            } else {
//          super.onBackPressed()
                finish()
//            System.exit(0)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        //hide
//        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        if (id == R.id.action_settings) {
            LogUtil.i(TAG, "action_settings")
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_setting -> {

            }
            R.id.nav_about -> {
                AboutActivity.launch(this)
            }
//            R.id.nav_camera -> {
//            }
//            R.id.nav_gallery -> {
//            }
//            R.id.nav_slideshow -> {
//            }
//            R.id.nav_manage -> {
//            }
//            R.id.nav_developer -> {
//            }
//            R.id.nav_version -> {
//            }
            else -> {
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }


    override fun initData() {
        initTheme()
        initBg()
        initCard()
    }


    override fun assignViews() {
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.setDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        //spinner_theme
        themeAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, themeList)
        spinner_theme.adapter = themeAdapter
        spinner_theme.setSelection(themeIndex)
        spinner_theme.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                themeIndex = position
                refreshData(themeList!![position])
                refreshViews()
            }
        }

        //spinner_bg
        bgAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, bgNameList)
        spinner_bg.adapter = bgAdapter
        spinner_bg.setSelection(bgIndex)
        spinner_bg.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                bgIndex = position
            }
        }

        //是否乱序
        check_is_shuffle.isChecked = isShuffle
        check_is_shuffle.setOnCheckedChangeListener { buttonView, isChecked ->
            isShuffle = isChecked
        }

        //cardAdapter
        cardAdapter = CardRecyclerViewAdapter(this)
        recycle_view.adapter = cardAdapter

        //swipe
        swipe_refresh_layout.setOnRefreshListener {
            swipe_refresh_layout.postRefreshing = true
            refreshData(themeList!![spinner_theme.selectedItemPosition])
            refreshViews()
            swipe_refresh_layout.postRefreshing = false
        }
    }

    override fun refreshViews() {
        cardAdapter!!.clear()
        cardAdapter!!.addItems(cardList!!)
    }


    private fun initTheme() {
        themeIndex = THEME_DEFAULT
        themeList = CardUtil.getThemeList()
    }

    private fun initBg() {
        bgIndex = BG_DEFAULT
        bgList = CardUtil.getBgResIdList()
        bgNameList = CardUtil.getBgResNameList()
    }

    private fun initCard() {
        refreshData(themeList!![themeIndex])
    }


    /**
     * 刷新数据
     */
    fun refreshData(value: String) {

//        bgIndex - 1：全部是0，则全部都显示，如果不是，则-1，刚好对上，详见Constant

        when (value) {
            Constant.THEME_36 -> {
                cardList = CardUtil.getAmazing36Records(isShuffle, bgIndex - 1)
            }
            Constant.THEME_FRIEND -> {
                cardList = CardUtil.getFriendRecords(isShuffle, bgIndex - 1)
            }
            else -> {
                cardList = CardUtil.getAmazing36Records(isShuffle, bgIndex - 1)
            }
        }
    }


    companion object {
        private val TAG = MainActivity::class.java.simpleName

        /** 最后一次点击返回的时间，用于判断退出 */
        private var lastBackPressTime: Long = 0

        fun launch(activity: Activity) {
            val intent = Intent(activity, MainActivity::class.java)
            activity.startActivity(intent)
        }
    }
}
