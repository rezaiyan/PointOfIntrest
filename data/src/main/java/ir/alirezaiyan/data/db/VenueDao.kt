package ir.alirezaiyan.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ir.alirezaiyan.data.model.VenueEntity

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 5/2/2020 2:08 AM.
 */
@Dao
interface VenueDao {

    @Query("SELECT * FROM venue WHERE x between :xFrom AND :xTo AND y between :yFrom AND :yTo")
    fun getNearVenues(
        xFrom: Double,
        xTo: Double,
        yFrom: Double,
        yTo: Double
    ): List<VenueEntity>

    @Query("SELECT * FROM venue")
    fun getAll(): List<VenueEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertVenue(venue: VenueEntity)

    @Query("SELECT * FROM venue WHERE id = :id")
    fun findById(id: String): VenueEntity?

    @Query("DELETE FROM venue")
    fun truncate()
}