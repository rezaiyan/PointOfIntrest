package ir.alirezaiyan.main.model

data class VenueUiModel(
    val title: String, val photoUrl: String, val rating: Float,
    val formattedAddress: String?, val formattedPhone: String?
)