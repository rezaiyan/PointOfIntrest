package ir.alirezaiyan.poi.di

import dagger.Component
import dagger.android.AndroidInjectionModule
import ir.alirezaiyan.poi.PoiApp

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 4/30/2020 1:18 PM.
 */
@Component(
    modules = [
        AndroidInjectionModule::class, AppModule::class, ActivityModule::class]
)
interface AppComponent {
    fun inject(app: PoiApp)
}