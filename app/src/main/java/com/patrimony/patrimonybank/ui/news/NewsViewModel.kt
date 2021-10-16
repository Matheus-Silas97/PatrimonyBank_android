package com.patrimony.patrimonybank.ui.news

import androidx.lifecycle.ViewModel
import com.patrimony.patrimonybank.R
import com.patrimony.patrimonybank.api.model.NewsModel

class NewsViewModel: ViewModel() {

    fun listNews():MutableList<NewsModel>{
        val list = mutableListOf<NewsModel>()
        list.add(NewsModel("Binance", "Binance ficou maluca, biticoin de graça pra todo mundo que estiver lendo.", R.drawable.binance))
        list.add(NewsModel("Criptomoeda", "Bitica começa a subir adoidado chutando tudo que esta na frente dando cabeçada em cabrito voador", R.drawable.bitcoin))

        return list
    }
}