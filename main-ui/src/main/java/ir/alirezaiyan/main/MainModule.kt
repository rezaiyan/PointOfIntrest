package ir.alirezaiyan.main

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import ir.alirezaiyan.sdk.ui.core.ViewModelKey

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 4/30/2020 12:07 PM.
 */
@Module
interface MainModule {
    @ContributesAndroidInjector
    fun mainFragment(): MainFragment

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindsMainViewModel(mainViewModel: MainViewModel): ViewModel
}