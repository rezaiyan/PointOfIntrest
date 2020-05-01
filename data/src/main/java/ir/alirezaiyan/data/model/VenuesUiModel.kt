package ir.alirezaiyan.data.model

import android.os.Parcel
import android.os.Parcelable


data class VenueUiModel(
    val id: String, val title: String, val photoUrl: String, val rating: Float,
    val formattedAddress: String?, val formattedPhone: String?
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString()!!,
        source.readString()!!,
        source.readString()!!,
        source.readFloat(),
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(id)
        writeString(title)
        writeString(photoUrl)
        writeFloat(rating)
        writeString(formattedAddress)
        writeString(formattedPhone)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<VenueUiModel> = object : Parcelable.Creator<VenueUiModel> {
            override fun createFromParcel(source: Parcel): VenueUiModel = VenueUiModel(source)
            override fun newArray(size: Int): Array<VenueUiModel?> = arrayOfNulls(size)
        }
    }
}