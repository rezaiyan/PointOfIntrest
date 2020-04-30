package ir.alirezaiyan.sdk.ui.core

import androidx.fragment.app.FragmentActivity
import ir.alirezaiyan.sdk.ui.BaseFragment

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 4/30/2020 1:01 PM.
 */
interface NavigationController {
    fun navigateToDetail(fragment: BaseFragment)
    fun showError(activity: FragmentActivity, error: String?)
}