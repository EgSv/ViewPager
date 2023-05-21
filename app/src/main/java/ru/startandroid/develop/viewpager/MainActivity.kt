package ru.startandroid.develop.viewpager

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener

const val TAG = "myLogs"
const val PAGE_COUNT = 10

class MainActivity : FragmentActivity() {

    private var pager: ViewPager? = null
    private var pagerAdapter: PagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pager = findViewById<View>(R.id.pager) as ViewPager
        pagerAdapter = MyFragmentPagerAdapter(supportFragmentManager)
        pager!!.adapter = pagerAdapter

        pager!!.setOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageSelected(position: Int) {
                Log.d(TAG, "onPageSelected, position = $position")
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) { }

            override fun onPageScrollStateChanged(state: Int) { }
        } )
    }

    private class MyFragmentPagerAdapter(fm: FragmentManager?): FragmentPagerAdapter(fm!!) {
        override fun getItem(position: Int): Fragment {
            return PageFragment.newInstance(position)
        }

        override fun getCount(): Int {
            return PAGE_COUNT
        }

        override fun getPageTitle(position: Int): CharSequence {
            return "Title $position"
        }
    }
}