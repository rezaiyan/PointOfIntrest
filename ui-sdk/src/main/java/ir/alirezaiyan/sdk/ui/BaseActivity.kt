package ir.alirezaiyan.sdk.ui

import android.app.Activity
import android.os.Bundle
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.DaggerAppCompatActivity
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 5/1/2020 12:29 AM.
 */
abstract class BaseActivity : DaggerAppCompatActivity(), HasActivityInjector,
    HasSupportFragmentInjector {

    abstract fun progressBar(): ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var dispatchingFragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun activityInjector() = dispatchingActivityInjector
    override fun supportFragmentInjector() = dispatchingFragmentInjector

}