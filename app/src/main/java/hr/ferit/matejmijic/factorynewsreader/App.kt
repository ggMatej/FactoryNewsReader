package hr.ferit.matejmijic.factorynewsreader

import android.app.Application
import android.content.Context

class App: Application() {

    companion object {
        lateinit var instance: App
            private set

        fun getAppContext(): Context = instance.applicationContext
    }

    override fun onCreate() {
        instance = this
        super.onCreate()
    }
}