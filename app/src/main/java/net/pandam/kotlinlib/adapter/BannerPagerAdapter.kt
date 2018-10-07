package net.pandam.kotlinlib.adapter


import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import net.pandam.kotlinlib.fragment.BannerFragment

val Banner = Array(5, { i -> (i * i).toString() })

class BannerPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager){

    override fun getItem(position: Int): Fragment {
        return BannerFragment.newInstance(Banner.get(position))
    }

    override fun getCount(): Int {
        return Banner.size
    }
}
