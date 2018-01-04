package be.mine.warehouse

import android.animation.ValueAnimator
import android.annotation.TargetApi
import android.app.Activity
import android.app.FragmentManager
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v4.view.GravityCompat
import android.support.v4.view.ViewPager
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Gravity
import android.view.MenuItem
import android.view.Window
import butterknife.BindView
import butterknife.ButterKnife

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemSelectedListener {

    val TAG = "Main"

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_camera -> {
                Log.e(TAG, "CAMERA")
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }
        mDrawerLayout.closeDrawer(Gravity.START)
        return true
    }

    @BindView(R.id.toolbar)
    lateinit var mToolbar: Toolbar

    @BindView(R.id.drawer_layout)
    lateinit var mDrawerLayout: DrawerLayout

    @BindView(R.id.nav_view)
    lateinit var mNavigationView: NavigationView

    @BindView(R.id.navigation)
    lateinit var mBottomNavigationView: BottomNavigationView

    @BindView(R.id.view_pager)
    lateinit var mViewPager: ViewPager

    lateinit var mWindowCompat: WindowCompat

    interface WindowCompat {
        fun setStatusBarColor(color: Int)
    }

    var mPrimaryColor: Int = R.color.colorPrimary

    var mAccentColor: Int = R.color.colorAccent

    val mItems = ArrayList<Item>()

    private val mOnBottomItemSelectedListener = object : BottomNavigationView.OnNavigationItemSelectedListener {
        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            when (item.itemId) {
                R.id.navigation_home -> {
                    mViewPager.setCurrentItem(InventoryType.HOME, true)
                    return true
                }
                R.id.navigation_dashboard -> {
                    mViewPager.setCurrentItem(InventoryType.DASHBOARD, true)
                    return true
                }
                R.id.navigation_notifications -> {
                    mViewPager.setCurrentItem(InventoryType.NOTIFICATIONS, true)
                    return true
                }
                R.id.navigation_settings -> {
                    mViewPager.setCurrentItem(InventoryType.SETTINGS, true)
                    return true
                }
            }
            return false
        }
    }

    lateinit var mInventoryPagerAdapter: InventoryPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ButterKnife.bind(this)
        setSupportActionBar(mToolbar)

        val mActionBarDrawerDrawer = ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        mDrawerLayout.setDrawerListener(mActionBarDrawerDrawer);
        mActionBarDrawerDrawer.syncState()
        mNavigationView.setNavigationItemSelectedListener(this)

        mBottomNavigationView.setOnNavigationItemSelectedListener(mOnBottomItemSelectedListener)
        mInventoryPagerAdapter = InventoryPagerAdapter(supportFragmentManager)
        mViewPager.adapter = mInventoryPagerAdapter
        initItems()
        mWindowCompat = windowCompat(this)
        mViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            var mPrimaryAnimator: ValueAnimator? = null
            var mAccentAnimator: ValueAnimator? = null

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }
            override fun onPageSelected(position: Int) {
                if (mPrimaryAnimator != null && mPrimaryAnimator!!.isRunning)
                    mPrimaryAnimator!!.cancel()

                if (mAccentAnimator != null && mAccentAnimator!!.isRunning)
                    mAccentAnimator!!.cancel()

                val item = mItems.get(position)
                val primary = CCFAnimator.rgb(mPrimaryColor, item.primaryColor)
                mPrimaryAnimator = primary.asValueAnimator(CCFAnimator.OnNewColorListener { color ->
                    mWindowCompat.setStatusBarColor(color)
                }
                )
                mPrimaryAnimator!!.setDuration(250L)
                mPrimaryAnimator!!.start()

                val accent = CCFAnimator.rgb(
                        accentColor(mAccentColor, mPrimaryColor),
                        accentColor(item.accentColor, item.primaryColor)
                )

                mAccentAnimator = accent.asValueAnimator(CCFAnimator.OnNewColorListener { color ->
                    mBottomNavigationView.setBackgroundColor(color)
                    mToolbar.setBackgroundColor(color)
                })

                mAccentAnimator!!.setDuration(250L)
                mAccentAnimator!!.start()

                mPrimaryColor = item.primaryColor
                mAccentColor = item.accentColor

                when (position) {
                    InventoryType.HOME -> {
                        mBottomNavigationView.selectedItemId = R.id.navigation_home
                    }
                    InventoryType.DASHBOARD -> {
                        mBottomNavigationView.selectedItemId = R.id.navigation_dashboard
                    }
                    InventoryType.NOTIFICATIONS -> {
                        mBottomNavigationView.selectedItemId = R.id.navigation_notifications
                    }
                    InventoryType.SETTINGS -> {
                        mBottomNavigationView.selectedItemId = R.id.navigation_settings
                    }
                }
            }

        })
    }

    override fun onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    fun initItems() {
        mItems.add(Item(
                ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary),
                ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary),
                "First Teal")
        )

        mItems.add(Item(
                ContextCompat.getColor(getApplicationContext(), R.color.md_red_500),
                ContextCompat.getColor(getApplicationContext(), R.color.md_red_300),
                "Second Red")
        )

        mItems.add(Item(
                ContextCompat.getColor(getApplicationContext(), R.color.md_purple_500),
                ContextCompat.getColor(getApplicationContext(), R.color.md_purple_300),
                "Third Purple")
        )
        mItems.add(Item(
                ContextCompat.getColor(getApplicationContext(), R.color.md_blue_500),
                ContextCompat.getColor(getApplicationContext(), R.color.md_blue_300),
                "Forth Blue")
        )

    }

    fun windowCompat(activity: Activity): WindowCompat {
        var compat: WindowCompat
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            compat = WindowCompat21(activity.window)
        } else {
            compat = WindowCompatImpl()
        }
        return compat
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    class WindowCompat21 constructor(val mWindow: Window) : WindowCompat {
        override fun setStatusBarColor(color: Int) {
            mWindow.statusBarColor = color
        }
    }

    class WindowCompatImpl : WindowCompat {
        override fun setStatusBarColor(color: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }

    fun accentColor(accentColor: Int, primaryColor: Int): Int {
        var out: Int
        val animator = CCFAnimator.rgb(accentColor, primaryColor)
        out = animator.getColor(1F)
        return out
    }

    class InventoryPagerAdapter constructor(fragmenetManager: android.support.v4.app.FragmentManager?) : SmartFragmentStatePagerAdapter(fragmenetManager) {

        val TOTAL_PAGES = 4;

        override fun getCount(): Int {
            return TOTAL_PAGES
        }

        override fun getItem(position: Int): Fragment {
            return InventoryFragment.newInstance()
        }

        override fun getPageTitle(position: Int): CharSequence {
            when (position) {
                InventoryType.HOME -> {
                    return R.string.title_home.toString()
                }
                InventoryType.DASHBOARD -> {
                    return R.string.title_dashboard.toString()
                }
                InventoryType.NOTIFICATIONS -> {
                    return R.string.title_notifications.toString()
                }
                InventoryType.SETTINGS -> {
                    return R.string.title_settings.toString()
                }
            }
            return R.string.title_home.toString()
        }
    }

    class InventoryType {
        companion object {
            val HOME = 0
            val DASHBOARD = 1
            val NOTIFICATIONS = 2
            val SETTINGS = 3
        }
    }
}
