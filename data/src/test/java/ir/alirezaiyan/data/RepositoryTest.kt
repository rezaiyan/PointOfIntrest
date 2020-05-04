package ir.alirezaiyan.data

import ir.alirezaiyan.data.db.VenueDao
import ir.alirezaiyan.data.model.VenuesEntityModelMapper
import ir.alirezaiyan.data.remote.ApiService
import ir.alirezaiyan.data.remote.response.*
import ir.alirezaiyan.data.utils.*
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 5/4/2020 1:02 PM.
 */
class RepositoryTest {

    private val api = mock(ApiService::class.java)
    private val db = mock(VenueDao::class.java)
    private lateinit var repository: Repository
    private val mapper = VenuesEntityModelMapper()

    @Before
    fun init() {
        repository = Repository(api, db, mapper)
    }

    @Test
    fun getVenueTest(): Unit = runBlocking {
        val ll = "0.0,0.0"
        val offset = "0"
        val metadataResponse = MetaResponse(0, "1")
        val venue = VenueResponse(
            "1", "VenueName", 4F,
            Contact(), Location(emptyList(), 0.0, 0.0)
            , Stats(-1), emptyList()
            , emptyList(), Response(emptyList())
        )
        val items: List<VenuesResponse> = listOf(VenuesResponse(venue))
        val item = GroupsResponse(items)
        val groups: List<GroupsResponse<VenuesResponse>> = listOf(item)

        val response = Response(groups)

        val fourSquareResponse = FoursquareResponse(metadataResponse, response)


        `when`(api.explore(ll, offset)).thenReturn(fourSquareResponse)

        val venueEntity = mapper.map(fourSquareResponse.response.groups[0].items.map { it.venue })

        val x = ll.getLongitude().toX()
        val y = ll.getLatitude().toY()

        val range = Pair(x, y).getRange()

        `when`(db.getNearVenues(range.xFrom, range.xTo, range.yFrom, range.yTo)).thenReturn(
            venueEntity
        )

        val venues = repository.getVenues(ll, offset)
        Assert.assertNotNull(venues)
        Assert.assertEquals(venues.isRight, true)
        venues.either({}, {
            Assert.assertEquals(it.size, venueEntity.size)
        })
        return@runBlocking Unit
    }
}