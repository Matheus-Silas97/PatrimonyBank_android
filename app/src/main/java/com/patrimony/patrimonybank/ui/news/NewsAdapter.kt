package com.patrimony.patrimonybank.ui.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.patrimony.patrimonybank.databinding.ItemNewsBinding
import com.patrimony.patrimonybank.model.NewsModel

class NewsAdapter: RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private val mList = mutableListOf<NewsModel>()
    lateinit var binding: ItemNewsBinding

    inner class NewsViewHolder(binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: NewsModel) {
            binding.txtNameTheme.text = item.category
            binding.txtBodyNews.text = item.bodyNews
            binding.imgNews.setImageResource(item.image)

            binding.cardView.setOnClickListener { onItemClickLister?.onClick() }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.NewsViewHolder {
        binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsAdapter.NewsViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    override fun getItemCount(): Int = mList.size

    fun setList(list: List<NewsModel>) {
        mList.addAll(list)
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onClick()
    }

    private var onItemClickLister: OnItemClickListener? = null

    fun addOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickLister = onItemClickListener
    }
}