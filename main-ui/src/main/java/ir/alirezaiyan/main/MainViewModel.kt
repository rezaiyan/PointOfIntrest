package ir.alirezaiyan.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ir.alirezaiyan.data.model.VenueUiModel
import ir.alirezaiyan.sdk.core.utils.Failure
import javax.inject.Inject

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 4/29/2020 11:05 PM.
 */
class MainViewModel
@Inject constructor(private val userCase: MainUseCase) : ViewModel() {

    private val venueLiveData = MutableLiveData<List<VenueUiModel>>()
    private val stateLiveData = MutableLiveData<Boolean>()
    fun venueLiveData() = venueLiveData
    fun stateLiveData() = stateLiveData

    fun getVenues(offset: String = "0") {
        stateLiveData.value = true
        userCase(offset) { it.either(::onFailure, ::onSuccess) }
    }

    private fun onFailure(failure: Failure) {
        stateLiveData.value = false
    }

    private fun onSuccess(response: List<VenueUiModel>) {
        stateLiveData.value = false
        venueLiveData.value = response
    }

}