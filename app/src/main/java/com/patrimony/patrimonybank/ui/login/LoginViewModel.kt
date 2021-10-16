package com.patrimony.patrimonybank.ui.login

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.patrimony.patrimonybank.R

class LoginViewModel: ViewModel() {

    val loginError = MutableLiveData<String>()

    fun validateLogin(cpf: String, passoword: String, context: Context): Boolean {
        return if (cpf.isEmpty()) {
            loginError.value = context.getString(R.string.empty_cpf)
            false
        } else if (passoword.isEmpty()) {
            loginError.value = context.getString(R.string.empty_password)
            false
        } else {
            true
        }
    }
}