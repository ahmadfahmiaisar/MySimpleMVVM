package inn.mroyek.mysimplemvvm.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import inn.mroyek.mysimplemvvm.presentation.PostViewModel
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun applicationContext(context: Context) : Builder

        fun build() : AppComponent
    }

    fun postViewModelFactory() : ViewModelFactory<PostViewModel>
}