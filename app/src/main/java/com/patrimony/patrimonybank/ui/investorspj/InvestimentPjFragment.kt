package com.patrimony.patrimonybank.ui.investorspj

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.patrimony.patrimonybank.R
import com.patrimony.patrimonybank.api.response.InvestorsPFResponse2
import com.patrimony.patrimonybank.api.response.InvestorsPjResponse2
import com.patrimony.patrimonybank.databinding.FragmentInvestimentPjBinding
import com.patrimony.patrimonybank.ui.investors.InvestimentAdapter
import com.patrimony.patrimonybank.ui.investors.InvestimentViewModel
import com.patrimony.patrimonybank.utils.BaseFragment
import com.patrimony.patrimonybank.utils.Constants
import com.patrimony.patrimonybank.utils.SharedPreferences

class InvestimentPjFragment : BaseFragment() {

    private lateinit var binding: FragmentInvestimentPjBinding
    private lateinit var viewModel: InvestmentPjViewModel

    private lateinit var adapter: InvestimentPjAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInvestimentPjBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[InvestmentPjViewModel::class.java]

        onClick()

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        buildListInvestors()
    }

    private fun onClick() {
        binding.icSearch.setOnClickListener {
            if (binding.editSearch.text.toString().isNullOrEmpty()) {
                buildListInvestors()
            } else {
                search(binding.editSearch.text.toString())
            }
        }
    }

    private fun search(documentNumber: String) {
        viewModel.investorDetailsPJ(documentNumber, requireContext())
            .observe(viewLifecycleOwner, Observer {
                if (it != null) {
                    val list = arrayListOf<InvestorsPjResponse2>()
                    list.add(it)

                    adapter = InvestimentPjAdapter()
                    binding.recyclerInvestiment.layoutManager = LinearLayoutManager(requireContext())
                    binding.recyclerInvestiment.adapter = adapter
                    adapter.updateTask(list)
                    adapter.addOnItemClickListener(object : InvestimentPjAdapter.OnItemClickListener {
                        override fun onClick(documentNumber: String, name: String) {
                            SharedPreferences.getInstance(requireContext()).saveString(Constants.NUMBER_DOCUMENT, documentNumber)
                            SharedPreferences.getInstance(requireContext()).saveString(Constants.NAME, name)
                            findNavController().navigate(
                                R.id.action_homeFragment_to_investimentDetailsPjFragment
                            )
                        }
                    })
                } else {
                    setNoResultAdapter(binding.recyclerInvestiment, "Nenhum investidor encontrado")
                }
            })
    }

    private fun buildListInvestors() {
        viewModel.listInvestmentPJ(requireContext()).observe(viewLifecycleOwner, Observer {
            if (!it.isNullOrEmpty()) {
                adapter = InvestimentPjAdapter()
                binding.recyclerInvestiment.layoutManager = LinearLayoutManager(requireContext())
                binding.recyclerInvestiment.adapter = adapter
                adapter.updateTask(it)
                adapter.addOnItemClickListener(object : InvestimentPjAdapter.OnItemClickListener {
                    override fun onClick(documentNumber: String, name: String) {
                        SharedPreferences.getInstance(requireContext()).saveString(Constants.NUMBER_DOCUMENT, documentNumber)
                        SharedPreferences.getInstance(requireContext()).saveString(Constants.NAME, name)
                        findNavController().navigate(
                            R.id.action_homeFragment_to_investimentDetailsPjFragment
                        )
                    }
                })
            } else {
                setNoResultAdapter(binding.recyclerInvestiment, "Nenhum investidor encontrado")
            }
        })
    }

}