package com.patrimony.patrimonybank.ui.investors

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InvestimentViewModel : ViewModel() {

    fun listInvestment(): MutableLiveData<List<InvestimentModel>> {
        val result = MutableLiveData<List<InvestimentModel>>()

        val list = mutableListOf<InvestimentModel>()
        list.add(InvestimentModel("Investidor A"))
        list.add(InvestimentModel("Investidor B"))
        list.add(InvestimentModel("Investidor C"))
        list.add(InvestimentModel("Investidor D"))
        list.add(InvestimentModel("Investidor E"))
        list.add(InvestimentModel("Investidor F"))

        result.value = list

        return result
    }
}