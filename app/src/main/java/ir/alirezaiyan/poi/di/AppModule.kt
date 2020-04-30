package ir.alirezaiyan.poi.di

import dagger.Module
import dagger.Provides
import ir.alirezaiyan.poi.core.PoiNavigationController
import ir.alirezaiyan.sdk.ui.core.NavigationController
import javax.inject.Singleton

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 4/30/2020 1:16 PM.
 */
@Module
class AppModule {

    @Provides
    @Singleton
    fun navigationController(navigationController: PoiNavigationController): NavigationController =
        navigationController

}