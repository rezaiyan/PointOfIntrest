package ir.alirezaiyan.data

import ir.alirezaiyan.data.remote.ApiService
import ir.alirezaiyan.data.remote.response.VenueResponse
import ir.alirezaiyan.sdk.core.utils.Either
import ir.alirezaiyan.sdk.core.utils.Failure
import ir.alirezaiyan.sdk.core.utils.None
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 4/30/2020 3:58 PM.
 */
class Repository @Inject constructor(private val api: ApiService) {

    suspend fun getVenues(location: String, offset: String): Either<Failure, List<VenueResponse>> {
        try {
            val list =
                api.explore(location, offset).response.groups[0].items.map { it.venue }
            return Either.Right(list)
        } catch (http: HttpException) {
            return Either.Left(Failure.ServerError)
        } catch (network: IOException) {
            return Either.Left(Failure.NetworkConnection)
        }

    }

    fun getVenue(params: String): Either<Failure, None> = Either.Right(None())
}