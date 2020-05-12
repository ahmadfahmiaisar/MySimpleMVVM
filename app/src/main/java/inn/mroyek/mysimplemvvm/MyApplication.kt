package inn.mroyek.mysimplemvvm

import android.app.Application
import inn.mroyek.mysimplemvvm.di.AppComponent
import inn.mroyek.mysimplemvvm.di.DaggerAppComponent
import inn.mroyek.mysimplemvvm.di.DaggerComponentProvider

class MyApplication : Application(), DaggerComponentProvider {

    override val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .applicationContext(applicationContext)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
    }
}