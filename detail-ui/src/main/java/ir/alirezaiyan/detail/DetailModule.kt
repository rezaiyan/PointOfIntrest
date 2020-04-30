package ir.alirezaiyan.detail

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 4/30/2020 12:33 PM.
 */
@Module
interface DetailModule {
    @ContributesAndroidInjector
    fun detailFragment(): DetailFragment
}