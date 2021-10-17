package com.patrimony.patrimonybank.ui.investorspj

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.patrimony.patrimonybank.api.Apifactory
import com.patrimony.patrimonybank.api.response.InvestorPjResponse
import com.patrimony.patrimonybank.api.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InvestmentPjViewModel:ViewModel() {

    val apiFactory = Apifactory.create(ApiService::class.java)

    fun listInvestmentPJ(): MutableLiveData<List<InvestorPjResponse>> {
        val result = MutableLiveData<List<InvestorPjResponse>>()

        apiFactory.listInvestorPJ().enqueue(object : Callback<List<InvestorPjResponse>> {
            override fun onResponse(
                call: Call<List<InvestorPjResponse>>,
                response: Response<List<InvestorPjResponse>>
            ) {
                if (response.isSuccessful){
                    result.value = response.body()
                }else{
                    result.value = null!!
                }
            }

            override fun onFailure(call: Call<List<InvestorPjResponse>>, t: Throwable) {
                result.value = null!!
            }

        })

        return result
    }


    fun investorDetailsPJ(documentoNumber: String): MutableLiveData<InvestorPjResponse> {
        val result = MutableLiveData<InvestorPjResponse>()

        apiFactory.investorDetailsPJ(documentoNumber).enqueue(object : Callback<InvestorPjResponse> {
            override fun onResponse(
                call: Call<InvestorPjResponse>,
                response: Response<InvestorPjResponse>
            ) {
                if (response.isSuccessful){
                    result.value = response.body()
                }else{
                    result.value = null!!
                }
            }

            override fun onFailure(call: Call<InvestorPjResponse>, t: Throwable) {
                result.value = null!!
            }

        })

        return result
    }
}