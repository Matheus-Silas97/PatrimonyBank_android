package com.patrimony.patrimonybank.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import com.patrimony.patrimonybank.R
import com.patrimony.patrimonybank.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        onClick()
        buildViewPager()

        return binding.root
    }

    private fun buildViewPager() {
        binding.viewPager.adapter = ViewPagerAdapter(requireActivity())
        TabLayoutMediator(binding.tablayout, binding.viewPager) { tab, position ->
            if (position == 0) {
                tab.text = getString(R.string.pf)
            } else {
                tab.text = getString(R.string.pj)
            }

        }.attach()
    }

    private fun onClick() {
        binding.toolbar.setOnMenuItemClickListener {
            return@setOnMenuItemClickListener optionsToolbar(it)
        }
    }

    private fun optionsToolbar(it: MenuItem): Boolean {
        return when (it.itemId) {
            R.id.ic_logout -> {
                findNavController().navigate(R.id.action_homeFragment_to_loginFragment2)
                true
            }
            else -> {
                false
            }
        }
    }




}