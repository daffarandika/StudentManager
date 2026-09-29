package com.itsrobocon.studentmanager

import android.app.Application
import com.itsrobocon.studentmanager.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class StudentApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@StudentApplication)
            modules(appModule)
        }
    }
}
