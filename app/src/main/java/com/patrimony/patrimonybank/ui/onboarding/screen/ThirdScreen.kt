package com.patrimony.patrimonybank.ui.onboarding.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.patrimony.patrimonybank.R
import com.patrimony.patrimonybank.databinding.FragmentThirdScreenBinding

class ThirdScreen : Fragment() {

    private lateinit var binding: FragmentThirdScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThirdScreenBinding.inflate(inflater, container, false)

        val viewPager =  activity?.findViewById<ViewPager2>(R.id.viewPager)

        binding.finish.setOnClickListener { findNavController().navigate(R.id.action_viewPagerFragment_to_registerActivity) }

        binding.arrowBack.setOnClickListener { viewPager?.currentItem = 1 }

        return binding.root
    }

}