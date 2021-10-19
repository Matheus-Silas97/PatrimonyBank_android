package com.patrimony.patrimonybank.ui.investorspj

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.patrimony.patrimonybank.R
import com.patrimony.patrimonybank.api.Apifactory
import com.patrimony.patrimonybank.api.response.InvestorsPjResponse2
import com.patrimony.patrimonybank.api.service.ApiService
import com.patrimony.patrimonybank.utils.Utils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InvestmentPjViewModel : ViewModel() {

    val apiFactory = Apifactory.create(ApiService::class.java)

    fun listInvestmentPJ(context: Context): MutableLiveData<List<InvestorsPjResponse2>> {
        val result = MutableLiveData<List<InvestorsPjResponse2>>()
        val dialog = Utils.showLoading(context, R.string.loading)

        apiFactory.listInvestorPJ().enqueue(object : Callback<List<InvestorsPjResponse2>> {
            override fun onResponse(
                call: Call<List<InvestorsPjResponse2>>,
                response: Response<List<InvestorsPjResponse2>>
            ) {
                if (response.isSuccessful) {
                    result.value = response.body()
                    dialog.dismiss()
                } else {
                    result.value = null!!
                    dialog.dismiss()
                }
            }

            override fun onFailure(call: Call<List<InvestorsPjResponse2>>, t: Throwable) {
                result.value = null!!
                dialog.dismiss()
            }

        })

        return result
    }


    fun investorDetailsPJ(
        documentoNumber: String,
        context: Context
    ): MutableLiveData<InvestorsPjResponse2> {
        val result = MutableLiveData<InvestorsPjResponse2>()
        val dialog = Utils.showLoading(context, R.string.loading)

        apiFactory.investorDetailsPJ(documentoNumber)
            .enqueue(object : Callback<InvestorsPjResponse2> {
                override fun onResponse(
                    call: Call<InvestorsPjResponse2>,
                    response: Response<InvestorsPjResponse2>
                ) {
                    if (response.isSuccessful) {
                        result.value = response.body()
                        dialog.dismiss()
                    } else {
                        result.value = null!!
                        dialog.dismiss()
                    }
                }

                override fun onFailure(call: Call<InvestorsPjResponse2>, t: Throwable) {
                    result.value = null!!
                    dialog.dismiss()
                }

            })

        return result
    }
}