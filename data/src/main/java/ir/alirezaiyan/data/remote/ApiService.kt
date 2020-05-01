package ir.alirezaiyan.data.remote

import ir.alirezaiyan.data.remote.response.FourSquareResponse
import ir.alirezaiyan.data.remote.response.VenuesResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 4/30/2020 4:07 PM.
 */

private const val SECRET_KEY = "RI0N3M10MD03G3E142KO32CQKV2O33ICOQOQXOPLKRGGGNB1"
private const val CLIENT_KEY = "ZLE4JE0B22L4EYYCO25YHWTFRAZFVIM04521K0332A5L32TE"

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
    ): FourSquareResponse<VenuesResponse>
}