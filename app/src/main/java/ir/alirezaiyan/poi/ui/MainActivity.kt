package ir.alirezaiyan.poi.ui

import android.os.Bundle
import android.widget.ProgressBar
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import ir.alirezaiyan.poi.R
import ir.alirezaiyan.sdk.ui.BaseActivity
import kotlinx.android.synthetic.main.main_activity.*

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 4/30/2020 12:17 PM.
 */
class MainActivity : BaseActivity() {

    override fun progressBar(): ProgressBar = progressBar

    override fun onCreate(savedInstanceState: Bundle?) {
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