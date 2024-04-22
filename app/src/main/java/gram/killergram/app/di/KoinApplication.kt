package gram.killergram.app.di

import android.app.Application
import org.koin.core.context.startKoin

class KoinApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {}
    }
}
