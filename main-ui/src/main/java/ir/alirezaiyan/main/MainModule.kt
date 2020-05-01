package ir.alirezaiyan.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import ir.alirezaiyan.data.Mapper
import ir.alirezaiyan.data.model.VenueUiModel
import ir.alirezaiyan.data.model.VenuesUiModelMapper
import ir.alirezaiyan.data.remote.response.VenueResponse
import ir.alirezaiyan.sdk.ui.core.ViewModelFactory
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
    abstract fun bindVenueUiModelMapper(
        mapper: VenuesUiModelMapper
    ): Mapper<VenueResponse, VenueUiModel>

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindsMainViewModel(mainViewModel: MainViewModel): ViewModel
}