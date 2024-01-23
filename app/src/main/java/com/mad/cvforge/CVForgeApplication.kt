package com.mad.cvforge

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CVForgeApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}