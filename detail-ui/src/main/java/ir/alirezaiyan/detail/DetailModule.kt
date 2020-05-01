package ir.alirezaiyan.detail

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import ir.alirezaiyan.sdk.ui.core.ViewModelKey

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 4/30/2020 12:33 PM.
 */
@Module
interface DetailModule {

    @ContributesAndroidInjector
    fun detailFragment(): DetailFragment

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    fun bindsDetailViewModel(detailViewModel: DetailViewModel): ViewModel

}