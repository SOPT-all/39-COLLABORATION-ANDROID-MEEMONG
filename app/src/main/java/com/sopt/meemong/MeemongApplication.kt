package com.sopt.meemong

import android.app.Application
import com.sopt.meemong.di.AppContainer

class MeemongApplication : Application() {
    val container: AppContainer by lazy { AppContainer() }

    override fun onCreate() {
        super.onCreate()
    }
}
