package com.patrimony.patrimonybank.ui.investorspj

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.patrimony.patrimonybank.R
import com.patrimony.patrimonybank.databinding.FragmentInvestimentDetailsPjBinding
import com.patrimony.patrimonybank.ui.investors.InvestimentViewModel
import com.patrimony.patrimonybank.utils.Constants
import com.patrimony.patrimonybank.utils.SharedPreferences

class InvestimentDetailsPjFragment : Fragment() {

    private lateinit var binding: FragmentInvestimentDetailsPjBinding
    private lateinit var viewModel: InvestmentPjViewModel

    private var documentNumber = ""
    private var name = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInvestimentDetailsPjBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[InvestmentPjViewModel::class.java]

//        val bundle = Bundle()
//
//        if (bundle != null) {
//            documentNumber = bundle.getString(Constants.NUMBER_DOCUMENT)!!
//            name = bundle.getString(Constants.NAME)!!
//
//            binding.toolbar.title = name
//        }

        documentNumber =
            SharedPreferences.getInstance(requireContext()).getString(Constants.NUMBER_DOCUMENT, "")
                .toString()
        name =
            SharedPreferences.getInstance(requireContext()).getString(Constants.NAME, "").toString()

        binding.toolbar.title = name

        onClick()
        details()

        return binding.root
    }

    private fun details() {
        viewModel.investorDetailsPJ(documentNumber).observe(viewLifecycleOwner, Observer {
            if (it != null) {
//                binding.txtName.text = it.brandName
//                binding.txtDocumentNumber.text = it.document.cpfNumber
//                binding.txtSex.text = it.sex
//                binding.txtCivilName.text = it.civilName
//                binding.txtSocialName.text = it.socialName
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