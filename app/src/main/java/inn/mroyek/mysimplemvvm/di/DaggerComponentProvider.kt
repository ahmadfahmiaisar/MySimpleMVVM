package inn.mroyek.mysimplemvvm.di

import android.app.Activity

interface DaggerComponentProvider {
    val appComponent: AppComponent
}
val Activity.injector: AppComponent get() = (application as DaggerComponentProvider).appComponent