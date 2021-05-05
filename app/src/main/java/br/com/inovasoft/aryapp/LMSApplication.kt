package br.com.inovasoft.aryapp

import android.app.Application

class LMSApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object {
        private var appInstance: LMSApplication? = null
        fun getInstance(): LMSApplication {
            if (appInstance == null) {
                throw IllegalStateException("Configurar application no Android Manifest")
            }
            return appInstance!!
        }
    }


}