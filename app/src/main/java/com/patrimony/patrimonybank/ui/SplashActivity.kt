package com.patrimony.patrimonybank.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.patrimony.patrimonybank.databinding.ActivitySplashBinding
import com.patrimony.patrimonybank.utils.BaseActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : BaseActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        GlobalScope.launch {
            delay(3000)
            //TODO Mudar destino para activity/fragment correto
            //startActivity(Intent(applicationContext, LoginActivity::class.java))
            finish()
        }
    }
}