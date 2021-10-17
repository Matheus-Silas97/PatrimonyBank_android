package com.patrimony.patrimonybank.api.service

import com.patrimony.patrimonybank.api.model.LoginModel
import com.patrimony.patrimonybank.api.response.InvestorPjResponse
import com.patrimony.patrimonybank.api.response.InvestorResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @POST("")
    fun doLogin(@Body model: LoginModel): Call<ResponseBody>

    //Conta PF
    @GET("Account")
    fun listInvestor(): Call<List<InvestorResponse>>

    @GET("Account/{cpf}")
    fun investorDetails(@Path("cpf") cpf: String): Call<InvestorResponse>

    //Conta PJ
    @GET("Account")
    fun listInvestorPJ(): Call<List<InvestorPjResponse>>

    @GET("Account/{cnpj}")
    fun investorDetailsPJ(@Path("cnpj") cnpj: String): Call<InvestorPjResponse>

}