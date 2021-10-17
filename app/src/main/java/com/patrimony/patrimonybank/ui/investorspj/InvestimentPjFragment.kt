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
import com.patrimony.patrimonybank.databinding.FragmentInvestimentPjBinding
import com.patrimony.patrimonybank.ui.investors.InvestimentAdapter
import com.patrimony.patrimonybank.ui.investors.InvestimentViewModel
import com.patrimony.patrimonybank.utils.BaseFragment
import com.patrimony.patrimonybank.utils.Constants

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

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        buildListInvestors()
    }

    private fun buildListInvestors() {
        viewModel.listInvestmentPJ().observe(viewLifecycleOwner, Observer {
            if (!it.isNullOrEmpty()) {
                adapter = InvestimentPjAdapter()
                binding.recyclerInvestiment.layoutManager = LinearLayoutManager(requireContext())
                binding.recyclerInvestiment.adapter = adapter
                adapter.updateTask(it)
                adapter.addOnItemClickListener(object : InvestimentPjAdapter.OnItemClickListener {
                    override fun onClick(documentNumber: String, name: String) {
                        val bundle = Bundle()
                        bundle.putString(Constants.NUMBER_DOCUMENT, documentNumber)
                        bundle.putString(Constants.NAME, name)
                        findNavController().navigate(
                            R.id.action_investimentPjFragment_to_investimentDetailsPjFragment,
                            bundle
                        )
                    }
                })
            } else {
                setNoResultAdapter(binding.recyclerInvestiment, "Nenhum investidor encontrado")
            }
        })
    }

}