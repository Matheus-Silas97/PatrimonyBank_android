package com.patrimony.patrimonybank.ui.investors

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.patrimony.patrimonybank.api.Apifactory
import com.patrimony.patrimonybank.api.response.InvestorsPFResponse2
import com.patrimony.patrimonybank.api.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InvestimentViewModel : ViewModel() {

    val apiFactory = Apifactory.create(ApiService::class.java)

    fun listInvestment(): MutableLiveData<List<InvestorsPFResponse2>> {
        val result = MutableLiveData<List<InvestorsPFResponse2>>()

       apiFactory.listInvestor().enqueue(object : Callback<List<InvestorsPFResponse2>>{
           override fun onResponse(
               call: Call<List<InvestorsPFResponse2>>,
               response: Response<List<InvestorsPFResponse2>>
           ) {
               if (response.isSuccessful){
                   result.value = response.body()
               }else{
                   result.value = null!!
               }
           }

           override fun onFailure(call: Call<List<InvestorsPFResponse2>>, t: Throwable) {
               result.value = null!!
           }

       })

        return result
    }


    fun investorDetails(documentoNumber: String): MutableLiveData<InvestorsPFResponse2> {
        val result = MutableLiveData<InvestorsPFResponse2>()

        apiFactory.investorDetails(documentoNumber).enqueue(object : Callback<InvestorsPFResponse2>{
            override fun onResponse(
                call: Call<InvestorsPFResponse2>,
                response: Response<InvestorsPFResponse2>
            ) {
                if (response.isSuccessful){
                    result.value = response.body()
                }else{
                    result.value = null!!
                }
            }

            override fun onFailure(call: Call<InvestorsPFResponse2>, t: Throwable) {
                result.value = null!!
            }

        })

        return result
    }
}