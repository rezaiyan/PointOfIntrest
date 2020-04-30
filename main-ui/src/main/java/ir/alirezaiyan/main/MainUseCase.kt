package ir.alirezaiyan.main

import ir.alirezaiyan.data.Mapper
import ir.alirezaiyan.data.Repository
import ir.alirezaiyan.data.remote.response.VenueResponse
import ir.alirezaiyan.main.model.VenueUiModel
import ir.alirezaiyan.sdk.core.domain.UseCase
import ir.alirezaiyan.sdk.core.utils.map
import javax.inject.Inject

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 4/30/2020 12:33 PM.
 */
class MainUseCase
@Inject constructor(
    private val repository: Repository,
    private val mapper: Mapper<VenueResponse, VenueUiModel>
) : UseCase<List<VenueUiModel>, String>() {

    override suspend fun run(params: String) = repository.getVenues(params).map { mapper.map(it) }
}