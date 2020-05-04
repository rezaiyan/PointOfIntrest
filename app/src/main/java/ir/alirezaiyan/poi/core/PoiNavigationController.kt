package ir.alirezaiyan.poi.core

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.google.android.material.snackbar.Snackbar
import ir.alirezaiyan.poi.R
import ir.alirezaiyan.sdk.ui.BaseFragment
import ir.alirezaiyan.sdk.ui.core.NavigationController
import ir.alirezaiyan.sdk.ui.navigate
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 4/30/2020 1:03 PM.
 */
@Singleton
class PoiNavigationController @Inject constructor() : NavigationController {

    override fun navigateToDetail(
        fragment: BaseFragment,
        bundle: Bundle
    ) {

        fragment.navigate(R.id.detail, bundle)
    }

    override fun showError(activity: FragmentActivity, error: String?) {
        Snackbar.make(
            activity.findViewById(android.R.id.content), error
                ?: "Error", Snackbar.LENGTH_LONG
        ).show()
    }
}