package com.patrimony.patrimonybank.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.patrimony.patrimonybank.databinding.ActivityLoginBinding
import com.patrimony.patrimonybank.utils.BaseActivity

class LoginActivity : BaseActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}