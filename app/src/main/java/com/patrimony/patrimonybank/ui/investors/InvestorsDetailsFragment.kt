package com.patrimony.patrimonybank.ui.investors

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.patrimony.patrimonybank.R
import com.patrimony.patrimonybank.databinding.FragmentInvestorsDetailsBinding
import com.patrimony.patrimonybank.utils.BaseFragment

class InvestorsDetailsFragment : BaseFragment() {

    private lateinit var binding: FragmentInvestorsDetailsBinding
    private lateinit var viewModel: InvestimentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInvestorsDetailsBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[InvestimentViewModel::class.java]

        onClick()
        details()

        return binding.root
    }

    private fun details() {
        viewModel.investorDetails().observe(viewLifecycleOwner, Observer {
            if (it != null) {

            } else {
                activity?.onBackPressed()
            }
        })
    }

    private fun onClick() {
        binding.toolbar.setNavigationOnClickListener {
            //  parentFragmentManager.popBackStack()
            // findNavController().navigate(R.id.action_investorsDetailsFragment_to_investorsFragment)
            activity?.onBackPressed()
        }

    }
}