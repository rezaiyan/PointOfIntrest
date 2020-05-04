package ir.alirezaiyan.detail

import androidx.lifecycle.MutableLiveData
import ir.alirezaiyan.data.model.VenueUiModel
import ir.alirezaiyan.sdk.core.base.BaseViewModel
import ir.alirezaiyan.sdk.core.utils.Failure
import javax.inject.Inject

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 4/30/2020 12:32 PM.
 */
class DetailViewModel @Inject constructor(private val useCase: DetailUseCase) : BaseViewModel() {

    private val venueLiveData = MutableLiveData<VenueUiModel>()
    fun venueLiveData() = venueLiveData

    fun getVenue(id: String) = useCase(id) { it.either(::onFailure, ::onSuccess) }

    private fun onFailure(failure: Failure) {
        failureLiveData.value = failure
    }

    private fun onSuccess(response: VenueUiModel) {
        venueLiveData.value = response
    }

}