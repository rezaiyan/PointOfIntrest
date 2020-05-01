package ir.alirezaiyan.sdk.ui

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.navigation.fragment.findNavController
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import kotlin.system.exitProcess

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 4/30/2020 12:27 PM.
 */
open abstract class BaseFragment : DaggerFragment() {
    private var isShownDialog = false

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

    private fun showProgress() = progressStatus(View.VISIBLE)

    private fun hideProgress() = progressStatus(View.GONE)

    private fun progressStatus(viewStatus: Int) {
        (activity as BaseActivity).progressBar().visibility = viewStatus
    }

    fun showMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    protected fun openSetting(reqCode: Int) {
        if (!isShownDialog) {
            val dialog = AlertDialog.Builder(requireContext()).create()
            dialog.setMessage(getString(R.string.permission_alert))
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "SETTINGS") { _, _ ->
                isShownDialog = false; openAboutApp(reqCode)
            }
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "EXIT") { _, _ ->
                isShownDialog = false; exitProcess(0)
            }
            dialog.setCancelable(false)
            dialog.show()
        }
        isShownDialog = true
    }

    private fun openAboutApp(reqCode: Int) {
        val intent = Intent()
        intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
        val uri = Uri.fromParts("package", requireContext().packageName, null)
        intent.data = uri
        startActivityForResult(intent, reqCode)
    }

}

fun BaseFragment.navigate(@IdRes nodeId: Int, bundle: Bundle) {
    findNavController().navigate(nodeId, bundle)
}