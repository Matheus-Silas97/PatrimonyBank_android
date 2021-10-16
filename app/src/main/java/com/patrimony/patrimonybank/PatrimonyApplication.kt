package com.patrimony.patrimonybank

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class PatrimonyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        instance = applicationContext
    }
    companion object {
        @SuppressLint("StaticFieldLeak")
        var instance: Context? = null
            private set
    }
}