package ir.alirezaiyan.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ir.alirezaiyan.data.model.VenueEntity
import ir.alirezaiyan.data.utils.VenueConverter

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 5/2/2020 2:07 AM.
 */
@TypeConverters(VenueConverter::class)
@Database(entities = [VenueEntity::class], version = 1, exportSchema = false)
abstract class PoiDatabase : RoomDatabase() {
    abstract fun venueDao(): VenueDao
}