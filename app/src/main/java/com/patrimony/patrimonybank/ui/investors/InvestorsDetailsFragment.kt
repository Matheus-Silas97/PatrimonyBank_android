package com.patrimony.patrimonybank.ui.investors

import android.R.attr
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
import android.R.attr.defaultValue
import com.patrimony.patrimonybank.utils.Constants


class InvestorsDetailsFragment : BaseFragment() {

    private lateinit var binding: FragmentInvestorsDetailsBinding
    private lateinit var viewModel: InvestimentViewModel

    private var documentNumber = ""
    private var name = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInvestorsDetailsBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[InvestimentViewModel::class.java]

        val bundle = Bundle()

        if (bundle != null) {
            documentNumber = bundle.getString(Constants.NUMBER_DOCUMENT)!!
            name = bundle.getString(Constants.NAME)!!

            binding.toolbar.title = name
        }

        onClick()
        details()

        return binding.root
    }

    private fun details() {
        viewModel.investorDetails(documentNumber).observe(viewLifecycleOwner, Observer {
            if (it != null) {
                //TODO continuar os detalhes
                binding.txtName.text = it.brandName
                binding.txtDocumentNumber.text = it.document.cpfNumber
                binding.txtSex.text = it.sex
                binding.txtCivilName.text = it.civilName
                binding.txtSocialName.text = it.socialName
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