package com.patrimony.patrimonybank.ui.login

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.patrimony.patrimonybank.R
import com.patrimony.patrimonybank.api.Apifactory
import com.patrimony.patrimonybank.api.model.LoginModel
import com.patrimony.patrimonybank.api.service.ApiService
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {

    val loginError = MutableLiveData<String>()
    val apiFactory = Apifactory.create(ApiService::class.java)

    fun validateLogin(cpf: String, passoword: String, context: Context): Boolean {
        return if (cpf.isEmpty()) {
            loginError.value = context.getString(R.string.empty_cpf_cnpj)
            false
        } else if (passoword.isEmpty()) {
            loginError.value = context.getString(R.string.empty_password)
            false
        } else {
            true
        }
    }

    fun doLogin(login: String, passoword: String): MutableLiveData<Boolean> {
        val result = MutableLiveData<Boolean>()

        result.value = login == "empresateste" && passoword == "123456"
//        val model = LoginModel(login, passoword)
//
//        apiFactory.doLogin(model).enqueue(object : Callback<ResponseBody> {
//            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
//                if (response.isSuccessful) {
//                    result.value = true
//                } else {
//                    result.value = false
//                    loginError.value = ""
//                }
//            }
//
//            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//                result.value = false
//                loginError.value = "Um erro inesperado aconteceu"
//            }
//
//        })

        return result
    }
}