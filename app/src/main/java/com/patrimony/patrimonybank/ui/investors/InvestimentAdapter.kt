package com.patrimony.patrimonybank.ui.investors

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.patrimony.patrimonybank.api.response.InvestorResponse
import com.patrimony.patrimonybank.databinding.ItemInvestimentBinding

class InvestimentAdapter() : RecyclerView.Adapter<InvestimentAdapter.InvestimentViewHolder>() {

    private var investimentList: List<InvestorResponse> = ArrayList()


    inner class InvestimentViewHolder(val binding: ItemInvestimentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(i: InvestorResponse) {
            binding.txtName.text = "Nome: ${i.socialName}"
            binding.txtDocumentNumber.text = "CPF: ${i.document.cpfNumber}"

            binding.layoutInvestiment.setOnClickListener {
                onItemClickLister?.onClick(i.document.cpfNumber, i.socialName)
            }
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

    fun updateTask(investimentAdapter: List<InvestorResponse>) {
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