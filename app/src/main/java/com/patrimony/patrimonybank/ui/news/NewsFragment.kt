package com.patrimony.patrimonybank.ui.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.patrimony.patrimonybank.databinding.FragmentNewsBinding

class NewsFragment : Fragment() {

    private var binding: FragmentNewsBinding? = null
    private lateinit var viewModel: NewsViewModel
    private val newsAdapter by lazy { NewsAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity())[NewsViewModel::class.java]

        initNewsList()

        return binding?.root!!
    }

    fun initNewsList(){
        binding?.recycler?.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            binding?.recycler?.adapter = newsAdapter
            newsAdapter.setList(viewModel.listNews())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}