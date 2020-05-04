package ir.alirezaiyan.data.model

import ir.alirezaiyan.data.mapper.Mapper
import ir.alirezaiyan.data.remote.response.VenueResponse
import javax.inject.Inject

class VenuesEntityModelMapper @Inject constructor() :
    Mapper<VenueResponse, VenueEntity> {

    override fun map(from: VenueResponse): VenueEntity = with(from) {
        VenueEntity(
            id = id,
            name = name,
            rating = rating,
            contact = contact,
            location = location,
            photos = photos,
            stats = stats
        )
    }
}