package ir.alirezaiyan.poi.di

import dagger.Binds
import dagger.Module
import ir.alirezaiyan.poi.core.PoiNavigationController
import ir.alirezaiyan.sdk.ui.core.NavigationController

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 4/30/2020 1:16 PM.
 */
@Module
abstract class AppModule {

    @Binds
    abstract fun navigationController(navigationController: PoiNavigationController): NavigationController

}