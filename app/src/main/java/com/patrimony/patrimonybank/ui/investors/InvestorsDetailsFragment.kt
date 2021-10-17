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
            documentNumber = bundle.getString(Constants.NUMBER_DOCUMENT).toString()
            name = bundle.getString(Constants.NAME).toString()

            binding.toolbar.title = name
        }

        onClick()
        details()

        return binding.root
    }

    private fun details() {
        viewModel.investorDetails(documentNumber).observe(viewLifecycleOwner, Observer {
            if (it != null) {
                binding.txtName.text = "Nome: ${it.socialName}"
                binding.txtMaritalStatus.text = "Status Civil: ${it.maritalStatusCode}"
                binding.txtSex.text = "Gênero: ${it.sex}"
                binding.txtDocumentCPF.text = "CPF: ${it.cpf}"
                binding.txtDocumentCNPJ.text = "CNPJ: ${it.companyCnpj}"
                binding.txtBrand.text = "Banco: ${it.brandName}"
                binding.txtCountry.text = "País: ${it.country}"
                binding.txtCity.text = "Cidade: ${it.townName}"
                binding.txtDistrict.text = "Bairoo: ${it.districtName}"
                binding.txtAddress.text = "Rua: ${it.address}"
                binding.txtPostCode.text = "Cödigo Postal: ${it.postCode}"
                binding.txtTypePhone1.text = "Tipo telefone 1: ${it.typePhone1}"
                binding.txtCountryCode.text = "Código pais: ${it.countryCallingCode1}"
                binding.txtAreaCodePhone1.text = "Código estado: ${it.areaCodePhone1}"
                binding.txtNumPhone1.text = "Numero telefone 1: ${it.numberPhone1}"
                binding.txtTypePhone2.text = "Tipo telefone 2: ${it.typePhone2}"
                binding.txtCountryCodePhone2.text = "Código pais: ${it.countryCallingCode2}"
                binding.txtAreaCodePhone2.text = "Código estado: ${it.areaCodePhone2}"
                binding.txtNumPhone2.text = "Numero telefone 1: ${it.numberPhone2}"
                binding.txtEmail.text = "Email: ${it.email}"

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