package ir.alirezaiyan.poi.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import ir.alirezaiyan.sdk.ui.core.ViewModelFactory

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 5/1/2020 11:13 AM.
 */
@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}