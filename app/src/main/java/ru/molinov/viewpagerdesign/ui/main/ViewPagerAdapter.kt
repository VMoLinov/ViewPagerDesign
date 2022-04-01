package ru.molinov.viewpagerdesign.ui.main

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import ru.molinov.viewpagerdesign.ui.second.SecondFragment
import ru.molinov.viewpagerdesign.ui.first.FirstFragment

class ViewPagerAdapter(
    private val fragmentManager: Fragment,
) : FragmentStateAdapter(fragmentManager) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FirstFragment()
            1 -> SecondFragment()
            else -> throw IllegalStateException("$position")
        }
    }
}