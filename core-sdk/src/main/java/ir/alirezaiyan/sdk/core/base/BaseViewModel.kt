package ir.alirezaiyan.sdk.core.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ir.alirezaiyan.sdk.core.utils.Failure

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 5/3/2020 12:13 AM.
 */
open class BaseViewModel : ViewModel() {
    protected val failureLiveData = MutableLiveData<Failure>()
    fun failureLiveData() = failureLiveData

}