package ir.alirezaiyan.data.remote.response

data class VenueResponse(
    val id: String, val name: String, val rating: Float = 0f,
    val contact: Contact?,
    val location: Location,
    val stats: Stats,
    val tips: List<Tip> = emptyList(),
    val photos: Response<PhotoResponse>
)

data class Contact(val formattedPhone: String = "")

data class Location(val formattedAddress: List<String>, val distance: Int = -1)

data class Stats(val checkinsCount: Int)

data class Tip(val text: String)