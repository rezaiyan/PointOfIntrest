package ir.alirezaiyan.main

import android.util.SparseArray
import androidx.lifecycle.MutableLiveData
import ir.alirezaiyan.data.model.VenueUiModel
import ir.alirezaiyan.sdk.core.base.BaseViewModel
import ir.alirezaiyan.sdk.core.utils.Failure
import javax.inject.Inject

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 4/29/2020 11:05 PM.
 */
class MainViewModel
@Inject constructor(private val userCase: MainUseCase) : BaseViewModel() {

    private val venueLiveData = MutableLiveData<List<VenueUiModel>>()
    private val stateLiveData = MutableLiveData<Boolean>()
    private var location: String = ""
    fun venueLiveData() = venueLiveData
    fun stateLiveData() = stateLiveData

    fun getVenues() {
        getVenues(location, forceUpdate = true)
    }

    fun getVenues(location: String, offset: String = "0", forceUpdate: Boolean = false) {
        if (this.location == location && !forceUpdate)
            return

        this.location = location
        stateLiveData.value = true
        if (location.isNotEmpty())
            userCase(SparseArray<String>().also {
                it.append(0, location)
                it.append(1, offset)
            }) { it.either(::onFailure, ::onSuccess) }
    }

    private fun onFailure(failure: Failure) {
        stateLiveData.value = false
        failureLiveData.value = failure
    }

    private fun onSuccess(response: List<VenueUiModel>) {
        stateLiveData.value = false
        venueLiveData.value = response
    }

}