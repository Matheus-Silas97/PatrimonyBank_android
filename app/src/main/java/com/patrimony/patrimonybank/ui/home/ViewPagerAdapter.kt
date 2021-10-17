package com.patrimony.patrimonybank.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.patrimony.patrimonybank.ui.investors.InvestorsFragment
import com.patrimony.patrimonybank.ui.investorspj.InvestimentPjFragment

class ViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        if (position == 0) {
            return InvestorsFragment()
        } else {
            return InvestimentPjFragment()
        }
    }


}