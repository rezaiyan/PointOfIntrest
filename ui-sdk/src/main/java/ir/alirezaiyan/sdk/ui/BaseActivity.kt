package ir.alirezaiyan.sdk.ui

import android.os.Bundle
import android.widget.ProgressBar
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 5/1/2020 12:29 AM.
 */
open abstract class BaseActivity : DaggerAppCompatActivity() {

    abstract fun progressBar(): ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }
}