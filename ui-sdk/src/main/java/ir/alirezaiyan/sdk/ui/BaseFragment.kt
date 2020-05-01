package ir.alirezaiyan.sdk.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.navigation.fragment.findNavController
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 4/30/2020 12:27 PM.
 */
open class BaseFragment : DaggerFragment() {

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    protected fun updateProgress(loading: Boolean) {
        if (loading)
            showProgress()
        else
            hideProgress()
    }

    protected fun showProgress() = progressStatus(View.VISIBLE)

    protected fun hideProgress() = progressStatus(View.GONE)

    private fun progressStatus(viewStatus: Int) {
        (activity as BaseActivity).progressBar().visibility = viewStatus
    }

}

fun BaseFragment.navigate(@IdRes nodeId: Int, bundle: Bundle) {
    findNavController().navigate(nodeId, bundle)
}