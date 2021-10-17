package com.patrimony.patrimonybank.ui.investorspj

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.patrimony.patrimonybank.api.response.InvestorPjResponse
import com.patrimony.patrimonybank.databinding.ItemInvestimentBinding
import com.patrimony.patrimonybank.ui.investors.InvestimentAdapter

class InvestimentPjAdapter() : RecyclerView.Adapter<InvestimentPjAdapter.InvestimentViewHolder>() {

    private var investimentList: List<InvestorPjResponse> = ArrayList()


    inner class InvestimentViewHolder(val binding: ItemInvestimentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(i: InvestorPjResponse) {
//            binding.txtName.text = "Nome: ${i.brandName}"
//            binding.txtDocumentNumber.text = "CNPJ: ${i.document.cpfNumber}"
//
//            binding.layoutInvestiment.setOnClickListener {
//                onItemClickLister?.onClick(i.document.cpfNumber, i.brandName)
//            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InvestimentViewHolder {
        val binding =
            ItemInvestimentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return InvestimentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: InvestimentViewHolder, position: Int) {
        holder.bind(investimentList[position])
    }

    override fun getItemCount(): Int = investimentList.size

    fun updateTask(investimentAdapter: List<InvestorPjResponse>) {
        this.investimentList = investimentAdapter
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onClick(documentNumber: String, name: String)
    }

    private var onItemClickLister: OnItemClickListener? = null

    fun addOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickLister = onItemClickListener
    }
}