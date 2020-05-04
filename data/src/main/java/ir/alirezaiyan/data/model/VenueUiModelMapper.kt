package ir.alirezaiyan.data.model

import ir.alirezaiyan.data.mapper.Mapper
import ir.alirezaiyan.data.remote.response.PhotoResponse
import javax.inject.Inject

class VenueUiModelMapper @Inject constructor() :
    Mapper<VenueEntity, VenueUiModel> {

    override fun map(from: VenueEntity): VenueUiModel = with(from) {
        VenueUiModel(
            id,
            name,
            if (photos.groups.isNotEmpty()) buildPhotoUrl(photos.groups[0].items[0]) else "",
            normalizeRating(rating),
            location.formattedAddress.joinToString(","),
            contact.formattedPhone
        )
    }

    private fun normalizeRating(rating: Float) = rating * 5f / 10f

    private fun buildPhotoUrl(photo: PhotoResponse): String = with(photo) {
        "$prefix${width}x$height$suffix"
    }
}