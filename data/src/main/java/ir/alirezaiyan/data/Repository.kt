package ir.alirezaiyan.data

import ir.alirezaiyan.data.db.VenueDao
import ir.alirezaiyan.data.mapper.Mapper
import ir.alirezaiyan.data.model.VenueEntity
import ir.alirezaiyan.data.remote.ApiService
import ir.alirezaiyan.data.remote.response.VenueResponse
import ir.alirezaiyan.data.utils.getLatitude
import ir.alirezaiyan.data.utils.getLongitude
import ir.alirezaiyan.data.utils.toX
import ir.alirezaiyan.data.utils.toY
import ir.alirezaiyan.sdk.core.utils.Either
import ir.alirezaiyan.sdk.core.utils.Failure
import retrofit2.HttpException
import java.io.IOException
import java.util.concurrent.TimeUnit.DAYS
import javax.inject.Inject

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 4/30/2020 3:58 PM.
 */
class Repository @Inject constructor(
    private val api: ApiService,
    private val db: VenueDao,
    private val mapper: Mapper<VenueResponse, VenueEntity>
) {

    private val radios = 100
    suspend fun getVenues(location: String, offset: String): Either<Failure, List<VenueEntity>> {

        val x = location.getLongitude().toX()
        val y = location.getLatitude().toY()

        val xFrom = x - radios
        val xTo = x + radios
        val yFrom = y - radios
        val yTo = y + radios

        val venues = db.getNearVenues(xFrom, xTo, yFrom, yTo)
        return if (venues.isNotEmpty()) {
            val isExpired: Boolean =
                System.currentTimeMillis() - venues[0].created_at > DAYS.toMillis(2)
            if (!isExpired)
                Either.Right(venues)
            else {
                db.truncate()
                getRemoteData(location, offset)
            }
        } else getRemoteData(location, offset)
    }

    private suspend fun getRemoteData(
        location: String,
        offset: String
    ): Either<Failure, List<VenueEntity>> {
        return try {
            val venues = api.explore(location, offset).response.groups[0].items.map { it.venue }
            val entities = mapper.map(venues)
            entities.forEach { db.insertVenue(it) }
            Either.Right(entities)
        } catch (http: HttpException) {
            Either.Left(Failure.ServerError)
        } catch (network: IOException) {
            Either.Left(Failure.NetworkConnection)
        }
    }

    fun getVenue(params: String): Either<Failure, VenueEntity> {
        val it = db.findById(params)
        return if (it != null)
            Either.Right(it)
        else
            Either.Left(Failure.NotFound)
    }
}