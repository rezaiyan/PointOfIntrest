package ir.alirezaiyan.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import ir.alirezaiyan.data.remote.response.*
import ir.alirezaiyan.data.utils.toX
import ir.alirezaiyan.data.utils.toY

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 5/2/2020 2:08 AM.
 */
@Entity(tableName = "venue", indices = [Index("_id", unique = true)])
class VenueEntity {
    @PrimaryKey(autoGenerate = true)
    var _id: Int = 0
    var id: String = ""
    var name: String = ""
    var rating: Float = 0f
    var photos: Response<PhotoResponse> = Response(emptyList())
    var contact: Contact = Contact()
    var location: Location = Location(emptyList(), 0.0, 0.0)
    var stats: Stats = Stats(-1)

    @ColumnInfo(name = "x")
    var x: Double? = null
        get() {
            return location.lng.toX()
        }

    @ColumnInfo(name = "y")
    var y: Double? = null
        get() {
            return location.lat.toY()
        }

    @ColumnInfo(name = "created_at")
    var created_at: Long = 0
        get() {
            return System.currentTimeMillis()
        }

    constructor(
        id: String,
        name: String,
        rating: Float = 0f,
        contact: Contact?,
        photos: Response<PhotoResponse>,
        location: Location,
        stats: Stats?
    ) {
        this.id = id
        this.name = name
        this.rating = rating
        this.contact = contact ?: Contact()
        this.photos = photos
        this.location = location
        this.stats = stats ?: Stats(-1)
    }
}