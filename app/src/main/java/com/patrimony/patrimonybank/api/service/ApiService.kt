package com.patrimony.patrimonybank.api.service

import com.patrimony.patrimonybank.api.model.LoginModel
import com.patrimony.patrimonybank.api.response.InvestorDetailsResponse
import com.patrimony.patrimonybank.api.response.InvestorList
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("")
    fun doLogin(@Body model: LoginModel): Call<ResponseBody>

    @GET("")
    fun listInvestor(): Call<List<InvestorList>>

    @GET("")
    fun investorDetails(): Call<InvestorDetailsResponse>

}