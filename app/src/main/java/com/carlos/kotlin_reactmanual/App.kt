package com.carlos.kotlin_reactmanual

import android.app.Application

class App:Application() {

    override fun onCreate() {
        super.onCreate()
        ItemsProvider.starEmitting()
    }
}