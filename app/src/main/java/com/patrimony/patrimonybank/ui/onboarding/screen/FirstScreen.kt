package com.patrimony.patrimonybank.ui.onboarding.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.patrimony.patrimonybank.R
import com.patrimony.patrimonybank.databinding.FragmentFirstScreenBinding

class FirstScreen : Fragment() {

    private lateinit var binding: FragmentFirstScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstScreenBinding.inflate(inflater, container, false)

        val viewPager =  activity?.findViewById<ViewPager2>(R.id.viewPager)

        binding.arrowNext.setOnClickListener { viewPager?.currentItem = 1 }

        return binding.root
    }

}