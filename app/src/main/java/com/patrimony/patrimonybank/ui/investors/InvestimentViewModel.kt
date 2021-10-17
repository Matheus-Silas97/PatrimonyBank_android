package com.patrimony.patrimonybank.ui.investors

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.patrimony.patrimonybank.api.Apifactory
import com.patrimony.patrimonybank.api.response.InvestorResponse
import com.patrimony.patrimonybank.api.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InvestimentViewModel : ViewModel() {

    val apiFactory = Apifactory.create(ApiService::class.java)

    fun listInvestment(): MutableLiveData<List<InvestorResponse>> {
        val result = MutableLiveData<List<InvestorResponse>>()

       apiFactory.listInvestor().enqueue(object : Callback<List<InvestorResponse>>{
           override fun onResponse(
               call: Call<List<InvestorResponse>>,
               response: Response<List<InvestorResponse>>
           ) {
               if (response.isSuccessful){
                   result.value = response.body()
               }else{
                   result.value = null!!
               }
           }

           override fun onFailure(call: Call<List<InvestorResponse>>, t: Throwable) {
               result.value = null!!
           }

       })

        return result
    }


    fun investorDetails(documentoNumber: String): MutableLiveData<InvestorResponse> {
        val result = MutableLiveData<InvestorResponse>()

        apiFactory.investorDetails(documentoNumber).enqueue(object : Callback<InvestorResponse>{
            override fun onResponse(
                call: Call<InvestorResponse>,
                response: Response<InvestorResponse>
            ) {
                if (response.isSuccessful){
                    result.value = response.body()
                }else{
                    result.value = null!!
                }
            }

            override fun onFailure(call: Call<InvestorResponse>, t: Throwable) {
                result.value = null!!
            }

        })

        return result
    }
}