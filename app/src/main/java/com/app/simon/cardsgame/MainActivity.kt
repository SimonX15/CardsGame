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
import com.app.simon.base.BaseActivity
import com.app.simon.base.callback.IViewCallBack
import com.app.simon.base.util.LogUtil
import com.app.simon.base.util.MathUtil
import com.app.simon.cardsgame.adapter.CardTypeRecyclerViewAdapter
import com.app.simon.cardsgame.data.Constant
import com.app.simon.cardsgame.models.Card
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.util.*

class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener, IViewCallBack {

    private var cardTypeList: MutableList<Card>? = null
    private var adapter: CardTypeRecyclerViewAdapter? = null

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
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
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
        // Handle navigation view item clicks here.
        val id = item.itemId

        if (id == R.id.nav_camera) {
            // Handle the camera action
            LogUtil.i(TAG, "nav_camera")
        } else if (id == R.id.nav_gallery) {
            LogUtil.i(TAG, "nav_gallery")
        } else if (id == R.id.nav_slideshow) {
            LogUtil.i(TAG, "nav_slideshow")
        } else if (id == R.id.nav_manage) {
            LogUtil.i(TAG, "nav_manage")
        } else if (id == R.id.nav_share) {
            LogUtil.i(TAG, "nav_share")
        } else if (id == R.id.nav_send) {
            LogUtil.i(TAG, "nav_send")
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }


    override fun initData() {
        cardTypeList = ArrayList<Card>()

        Constant.VALUE_THEME2.forEachIndexed { index, value ->
            val card = Card()
            card.name = "NAME " + index
            card.type = Constant.CARD_TYPE[MathUtil.getRandomNum(0, Constant.CARD_TYPE.size)]
            card.content = value
            cardTypeList!!.add(card)
        }

        /*for (value in Constant.VALUE_THEME) {
            val card = Card()
            card.type = Constant.CARD_TYPE[MathUtil.getRandomNum(0, Constant.CARD_TYPE.size)]
            card.content = value
            cardTypeList!!.add(card)
        }*/
    }


    override fun assignViews() {
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.setDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        //adapter
        adapter = CardTypeRecyclerViewAdapter(this)
        recycle_view.adapter = adapter
        adapter!!.addItems(cardTypeList)
    }

    override fun refreshViews() {

    }

    companion object {
        private val TAG = MainActivity::class.java.simpleName

        fun launch(activity: Activity) {
            val intent = Intent(activity, MainActivity::class.java)
            activity.startActivity(intent)
        }
    }
}
