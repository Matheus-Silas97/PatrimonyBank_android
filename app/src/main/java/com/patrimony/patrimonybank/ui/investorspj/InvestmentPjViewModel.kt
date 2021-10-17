package com.patrimony.patrimonybank.ui.investorspj

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.patrimony.patrimonybank.api.Apifactory
import com.patrimony.patrimonybank.api.response.InvestorsPjResponse2
import com.patrimony.patrimonybank.api.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InvestmentPjViewModel:ViewModel() {

    val apiFactory = Apifactory.create(ApiService::class.java)

    fun listInvestmentPJ(): MutableLiveData<List<InvestorsPjResponse2>> {
        val result = MutableLiveData<List<InvestorsPjResponse2>>()

        apiFactory.listInvestorPJ().enqueue(object : Callback<List<InvestorsPjResponse2>> {
            override fun onResponse(
                call: Call<List<InvestorsPjResponse2>>,
                response: Response<List<InvestorsPjResponse2>>
            ) {
                if (response.isSuccessful){
                    result.value = response.body()
                }else{
                    result.value = null!!
                }
            }

            override fun onFailure(call: Call<List<InvestorsPjResponse2>>, t: Throwable) {
                result.value = null!!
            }

        })

        return result
    }


    fun investorDetailsPJ(documentoNumber: String): MutableLiveData<InvestorsPjResponse2> {
        val result = MutableLiveData<InvestorsPjResponse2>()

        apiFactory.investorDetailsPJ(documentoNumber).enqueue(object : Callback<InvestorsPjResponse2> {
            override fun onResponse(
                call: Call<InvestorsPjResponse2>,
                response: Response<InvestorsPjResponse2>
            ) {
                if (response.isSuccessful){
                    result.value = response.body()
                }else{
                    result.value = null!!
                }
            }

            override fun onFailure(call: Call<InvestorsPjResponse2>, t: Throwable) {
                result.value = null!!
            }

        })

        return result
    }
}