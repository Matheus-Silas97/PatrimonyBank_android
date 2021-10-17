package com.patrimony.patrimonybank.ui.splashscreen

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.patrimony.patrimonybank.R
import com.patrimony.patrimonybank.databinding.FragmentSplashBinding
import com.patrimony.patrimonybank.utils.Constants
import com.patrimony.patrimonybank.utils.SharedPreferences

class SplashFragment : Fragment() {

    private lateinit var binding: FragmentSplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(inflater, container, false)

        Handler(Looper.getMainLooper()).postDelayed({
            val token =
                SharedPreferences.getInstance(requireContext()).getString(Constants.TOKEN_KEY, "")
            if (true) {
                findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToViewPagerFragment())
            } else {
                findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToHomeFragment())
            }
        }, 3000)

        return binding.root
    }


}