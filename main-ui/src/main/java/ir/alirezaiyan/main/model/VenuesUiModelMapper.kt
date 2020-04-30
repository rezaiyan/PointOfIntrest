package ir.alirezaiyan.main.model

import ir.alirezaiyan.data.Mapper
import ir.alirezaiyan.data.remote.response.PhotoResponse
import ir.alirezaiyan.data.remote.response.VenueResponse
import javax.inject.Inject

class VenuesUiModelMapper @Inject constructor() : Mapper<VenueResponse, VenueUiModel> {

    override fun map(from: VenueResponse): VenueUiModel = with(from) {
        VenueUiModel(
            name,
            if (photos.groups.isNotEmpty()) buildPhotoUrl(photos.groups[0].items[0]) else "",
            normalizeRating(rating),
            location.formattedAddress.joinToString(","),
            contact?.formattedPhone
        )
    }

    private fun normalizeRating(rating: Float) = rating * 5f / 10f

    private fun buildPhotoUrl(photo: PhotoResponse): String = with(photo) {
        "$prefix${width}x$height$suffix"
    }
}