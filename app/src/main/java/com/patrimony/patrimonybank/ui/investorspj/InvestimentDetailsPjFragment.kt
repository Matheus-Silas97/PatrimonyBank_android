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
        viewModel.investorDetailsPJ(documentNumber, requireContext())
            .observe(viewLifecycleOwner, Observer {
                if (it != null) {
                    binding.txtName.text = it.companyName
                    binding.txtFantasy.text = it.tradeName
                    binding.txtDocumentCNPJ.text = it.cnpjNumber
                    binding.txtCity.text = it.adressTownName
                    binding.txtAddress.text = it.adress
                    binding.txtDistrict.text = it.adressDistrictName
                    binding.txtPostCode.text = it.adressPostCode
                    binding.txtEmail.text = it.email
                    binding.txtTypePhone1.text = it.phonesType
                    binding.txtCountryCode.text = it.phonesCountryCallingCode
                    binding.txtAreaCodePhone1.text = "(${it.phonesAreaCode})"
                    binding.txtNumPhone1.text = it.phonesNumber
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