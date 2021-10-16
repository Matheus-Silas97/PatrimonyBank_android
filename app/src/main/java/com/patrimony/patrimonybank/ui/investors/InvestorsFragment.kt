package com.patrimony.patrimonybank.ui.investors

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
import com.patrimony.patrimonybank.databinding.FragmentInvestorsBinding
import com.patrimony.patrimonybank.utils.BaseFragment

class InvestorsFragment : BaseFragment() {

    private lateinit var binding: FragmentInvestorsBinding
    private lateinit var viewModel: InvestimentViewModel

    private lateinit var adapter: InvestimentAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInvestorsBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[InvestimentViewModel::class.java]

        onClick()
        buildListInvestors()

        return binding.root
    }

    private fun buildListInvestors() {
        viewModel.listInvestment().observe(viewLifecycleOwner, Observer {
            if (!it.isNullOrEmpty()) {
                adapter = InvestimentAdapter()
                binding.recyclerInvestiment.layoutManager = LinearLayoutManager(requireContext())
                binding.recyclerInvestiment.adapter = adapter
                adapter.updateTask(it)
                adapter.addOnItemClickListener(object : InvestimentAdapter.OnItemClickListener {
                    override fun onClick(id: Int) {
                        //TODO Ir para tela de detalhes do atendimento
                        findNavController().navigate(R.id.action_investorsFragment_to_investorsDetailsFragment)
                    }
                })
            } else {
                setNoResultAdapter(binding.recyclerInvestiment, "Nenhum investimento encontrado")
            }
        })
    }

    private fun onClick() {
        binding.toolbar.setOnMenuItemClickListener {
            return@setOnMenuItemClickListener optionsToolbar(it)
        }
    }

    private fun optionsToolbar(it: MenuItem): Boolean {
        return when (it.itemId) {
            R.id.ic_logout -> {
                findNavController().navigate(R.id.action_investorsFragment_to_loginFragment2)
                true
            }
            else -> {
                false
            }
        }
    }
}