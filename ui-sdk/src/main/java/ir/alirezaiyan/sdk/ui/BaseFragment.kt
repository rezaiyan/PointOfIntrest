package ir.alirezaiyan.sdk.ui

import android.content.Context
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
}

fun BaseFragment.navigate(@IdRes nodeId: Int) {
    findNavController().navigate(nodeId)
}