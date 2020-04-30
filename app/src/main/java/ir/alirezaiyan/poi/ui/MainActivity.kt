package ir.alirezaiyan.poi.ui

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import ir.alirezaiyan.poi.R
import kotlinx.android.synthetic.main.main_activity.*

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 4/30/2020 12:17 PM.
 */
class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        setSupportActionBar(toolbar)

        NavigationUI.setupActionBarWithNavController(
            this,
            findNavController(R.id.poi_nav_host_fragment)
        )
    }

    override fun onSupportNavigateUp() = findNavController(R.id.poi_nav_host_fragment).navigateUp()
}