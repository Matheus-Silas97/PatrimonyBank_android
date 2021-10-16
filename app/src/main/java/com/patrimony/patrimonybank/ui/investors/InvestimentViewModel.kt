package com.patrimony.patrimonybank.ui.investors

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.patrimony.patrimonybank.api.Apifactory
import com.patrimony.patrimonybank.api.response.InvestorDetailsResponse
import com.patrimony.patrimonybank.api.response.InvestorList
import com.patrimony.patrimonybank.api.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InvestimentViewModel : ViewModel() {

    val apiFactory = Apifactory.create(ApiService::class.java)

    fun listInvestment(): MutableLiveData<List<InvestorList>> {
        val result = MutableLiveData<List<InvestorList>>()

       apiFactory.listInvestor().enqueue(object : Callback<List<InvestorList>>{
           override fun onResponse(
               call: Call<List<InvestorList>>,
               response: Response<List<InvestorList>>
           ) {
               if (response.isSuccessful){
                   result.value = response.body()
               }else{
                   result.value = null!!
               }
           }

           override fun onFailure(call: Call<List<InvestorList>>, t: Throwable) {
               result.value = null!!
           }

       })

        return result
    }


    fun investorDetails(): MutableLiveData<InvestorDetailsResponse> {
        val result = MutableLiveData<InvestorDetailsResponse>()

        apiFactory.investorDetails().enqueue(object : Callback<InvestorDetailsResponse>{
            override fun onResponse(
                call: Call<InvestorDetailsResponse>,
                response: Response<InvestorDetailsResponse>
            ) {
                if (response.isSuccessful){
                    result.value = response.body()
                }else{
                    result.value = null!!
                }
            }

            override fun onFailure(call: Call<InvestorDetailsResponse>, t: Throwable) {
                result.value = null!!
            }

        })

        return result
    }
}