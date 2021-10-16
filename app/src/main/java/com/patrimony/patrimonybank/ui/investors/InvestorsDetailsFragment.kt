package com.patrimony.patrimonybank.ui.investors

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.patrimony.patrimonybank.R
import com.patrimony.patrimonybank.databinding.FragmentInvestorsDetailsBinding

class InvestorsDetailsFragment : Fragment() {

    private lateinit var binding: FragmentInvestorsDetailsBinding
    private lateinit var viewModel: InvestimentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInvestorsDetailsBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[InvestimentViewModel::class.java]

        onClick()

        return binding.root
    }

    private fun onClick() {
        binding.toolbar.setNavigationOnClickListener {
          //  parentFragmentManager.popBackStack()
           // findNavController().navigate(R.id.action_investorsDetailsFragment_to_investorsFragment)
            activity?.onBackPressed()
        }

    }
}