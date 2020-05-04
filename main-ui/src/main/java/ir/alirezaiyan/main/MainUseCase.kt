package ir.alirezaiyan.main

import android.util.SparseArray
import ir.alirezaiyan.data.Repository
import ir.alirezaiyan.data.mapper.Mapper
import ir.alirezaiyan.data.model.VenueEntity
import ir.alirezaiyan.data.model.VenueUiModel
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
    private val mapper: Mapper<VenueEntity, VenueUiModel>
) : UseCase<List<VenueUiModel>, SparseArray<String>>() {

    override suspend fun run(params: SparseArray<String>) =
        repository.getVenues(params.valueAt(0), params.valueAt(1)).map { mapper.map(it) }
}