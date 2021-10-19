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
import android.widget.Toast
import com.patrimony.patrimonybank.utils.Constants
import com.patrimony.patrimonybank.utils.SharedPreferences

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

//        val bundle = Bundle()
//
//        if (bundle != null) {
//            documentNumber = bundle.getString(Constants.NUMBER_DOCUMENT).toString()
//            name = bundle.getString(Constants.NAME).toString()
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
        viewModel.investorDetails(documentNumber, requireContext()).observe(viewLifecycleOwner, Observer {
            if (it != null) {
                binding.txtName.text = it.socialName
                binding.txtMaritalStatus.text = it.maritalStatusCode
                binding.txtSex.text = it.sex
                binding.txtDocumentCPF.text =it.cpf
                binding.txtDocumentCNPJ.text = it.companyCnpj
                binding.txtBrand.text = it.brandName
                binding.txtCountry.text = it.country
                binding.txtCity.text = it.townName
                binding.txtDistrict.text = it.districtName
                binding.txtAddress.text = it.address
                binding.txtPostCode.text = it.postCode
                binding.txtTypePhone1.text = it.typePhone1
                binding.txtCountryCode.text = it.countryCallingCode1
                binding.txtAreaCodePhone1.text = it.areaCodePhone1
                binding.txtNumPhone1.text = it.numberPhone1
                binding.txtTypePhone2.text = it.typePhone2
                binding.txtCountryCodePhone2.text = it.countryCallingCode2
                binding.txtAreaCodePhone2.text = it.areaCodePhone2
                binding.txtNumPhone2.text = it.numberPhone2
                binding.txtEmail.text = it.email

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