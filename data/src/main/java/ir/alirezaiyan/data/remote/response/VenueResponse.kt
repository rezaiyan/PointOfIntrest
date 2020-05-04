package ir.alirezaiyan.data.remote.response

data class VenueResponse(
    val id: String, val name: String, val rating: Float = 0f,
    val contact: Contact?,
    val location: Location,
    val stats: Stats,
    val categories: List<Categories>,
    val tips: List<Tip> = emptyList(),
    val photos: Response<PhotoResponse>
)

data class Contact(val formattedPhone: String = "")

data class Location(val formattedAddress: List<String>, val lat: Double, val lng: Double)

data class Stats(val checkinsCount: Int)

data class Tip(val text: String)

data class Categories(val icon: Icon)

data class Icon(val prefix: String, val suffix: String)