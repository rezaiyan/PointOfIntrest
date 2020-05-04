package ir.alirezaiyan.data.remote

import ir.alirezaiyan.data.remote.response.FoursquareResponse
import ir.alirezaiyan.data.remote.response.VenuesResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 4/30/2020 4:07 PM.
 */

private const val SECRET_KEY = "4Q0KGYME54ODC4NEIQ1RMEIMIIKV4T5ZMIHKXIPR4C3B1HZY"
private const val CLIENT_KEY = "XJJJIIFEJDOFTUWTOJ5KU3Q01IJEZO235P4CFSPOEDMM0PRX"

interface ApiService {
    @GET(
        "/v2/venues/explore?" +
                "v=20190101" +
                "&client_id=$CLIENT_KEY" +
                "&client_secret=$SECRET_KEY" +
                "&section=food" +
                "&venuePhotos=1" +
                "&radius=100" +
                "&limit=10"
    )
    suspend fun explore(
        @Query("ll") ll: String,
        @Query("offset") offset: String
    ): FoursquareResponse<VenuesResponse>
}