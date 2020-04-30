package ir.alirezaiyan.poi.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ir.alirezaiyan.detail.DetailModule
import ir.alirezaiyan.main.MainModule
import ir.alirezaiyan.poi.ui.MainActivity

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 4/30/2020 1:41 PM.
 */
@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(modules = [MainModule::class, DetailModule::class])
    abstract fun mainActivity(): MainActivity
}