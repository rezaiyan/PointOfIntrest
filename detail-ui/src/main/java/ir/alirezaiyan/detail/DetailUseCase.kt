package ir.alirezaiyan.detail

import ir.alirezaiyan.data.Repository
import ir.alirezaiyan.data.mapper.Mapper
import ir.alirezaiyan.data.model.VenueEntity
import ir.alirezaiyan.data.model.VenueUiModel
import ir.alirezaiyan.sdk.core.domain.UseCase
import ir.alirezaiyan.sdk.core.utils.Either
import ir.alirezaiyan.sdk.core.utils.Failure
import ir.alirezaiyan.sdk.core.utils.map
import javax.inject.Inject

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 4/30/2020 12:33 PM.
 */
class DetailUseCase @Inject constructor(
    private val repository: Repository,
    private val mapper: Mapper<VenueEntity, VenueUiModel>
) : UseCase<VenueUiModel, String>() {
    override suspend fun run(params: String): Either<Failure, VenueUiModel> =
        repository.getVenue(params).map { mapper.map(it) }
}