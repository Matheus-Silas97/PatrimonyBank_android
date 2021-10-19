package com.patrimony.patrimonybank.ui.investors

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.patrimony.patrimonybank.R
import com.patrimony.patrimonybank.api.Apifactory
import com.patrimony.patrimonybank.api.response.InvestorsPFResponse2
import com.patrimony.patrimonybank.api.service.ApiService
import com.patrimony.patrimonybank.utils.Utils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InvestimentViewModel : ViewModel() {

    val apiFactory = Apifactory.create(ApiService::class.java)

    fun listInvestment(context:Context): MutableLiveData<List<InvestorsPFResponse2>> {
        val result = MutableLiveData<List<InvestorsPFResponse2>>()
        val dialog = Utils.showLoading(context, R.string.loading)

       apiFactory.listInvestor().enqueue(object : Callback<List<InvestorsPFResponse2>>{
           override fun onResponse(
               call: Call<List<InvestorsPFResponse2>>,
               response: Response<List<InvestorsPFResponse2>>
           ) {
               if (response.isSuccessful){
                   result.value = response.body()
                   dialog.dismiss()
               }else{
                   result.value = null!!
                   dialog.dismiss()
               }
           }

           override fun onFailure(call: Call<List<InvestorsPFResponse2>>, t: Throwable) {
               result.value = null!!
               dialog.dismiss()
           }

       })

        return result
    }


    fun investorDetails(documentoNumber: String, context: Context): MutableLiveData<InvestorsPFResponse2> {
        val result = MutableLiveData<InvestorsPFResponse2>()
        val dialog = Utils.showLoading(context, R.string.loading)

        apiFactory.investorDetails(documentoNumber).enqueue(object : Callback<InvestorsPFResponse2>{
            override fun onResponse(
                call: Call<InvestorsPFResponse2>,
                response: Response<InvestorsPFResponse2>
            ) {
                if (response.isSuccessful){
                    result.value = response.body()
                    dialog.dismiss()
                }else{
                    result.value = null!!
                    dialog.dismiss()
                }
            }

            override fun onFailure(call: Call<InvestorsPFResponse2>, t: Throwable) {
                result.value = null!!
                dialog.dismiss()
            }

        })

        return result
    }
}