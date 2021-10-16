package com.patrimony.patrimonybank.ui.investors

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.patrimony.patrimonybank.api.response.InvestorList
import com.patrimony.patrimonybank.databinding.ItemInvestimentBinding

class InvestimentAdapter() : RecyclerView.Adapter<InvestimentAdapter.InvestimentViewHolder>() {

    private var investimentList: List<InvestorList> = ArrayList()


    inner class InvestimentViewHolder(val binding: ItemInvestimentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(investiment: InvestorList) {
            //TODO implementar itens da lista
            binding.titleInvestiment.text = investiment.a

            binding.layoutInvestiment.setOnClickListener {
                onItemClickLister?.onClick(1)
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

    fun updateTask(taskAdapter: List<InvestorList>) {
        this.investimentList = taskAdapter
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onClick(id: Int)
    }

    private var onItemClickLister: OnItemClickListener? = null

    fun addOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickLister = onItemClickListener
    }
}