package ir.alirezaiyan.poi

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import ir.alirezaiyan.poi.di.DaggerAppComponent
import javax.inject.Inject

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 4/30/2020 1:20 PM.
 */
class PoiApp : Application(), HasActivityInjector, HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>
    @Inject
    lateinit var dispatchingFragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun activityInjector() = dispatchingActivityInjector
    override fun supportFragmentInjector() = dispatchingFragmentInjector
    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.create().inject(this)
    }
}