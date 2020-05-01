package ir.alirezaiyan.poi.di

import dagger.Component
import dagger.android.AndroidInjectionModule
import ir.alirezaiyan.data.di.DataModule
import ir.alirezaiyan.poi.PoiApp
import javax.inject.Singleton

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 4/30/2020 1:18 PM.
 */
@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class, AppModule::class, ViewModelModule::class, ActivityModule::class, DataModule::class]
)
interface AppComponent {
    fun inject(app: PoiApp)
}