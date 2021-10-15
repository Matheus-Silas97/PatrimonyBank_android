package com.patrimony.patrimonybank.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.patrimony.patrimonybank.databinding.ActivityRegisterBinding
import com.patrimony.patrimonybank.utils.BaseActivity

class RegisterActivity : BaseActivity() {

    private lateinit var binding : ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}