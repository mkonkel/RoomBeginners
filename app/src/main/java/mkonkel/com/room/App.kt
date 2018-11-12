package mkonkel.com.room

import android.app.Application
import com.facebook.stetho.Stetho
import timber.log.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
        Timber.plant(Timber.DebugTree())
    }
}