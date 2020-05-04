package ir.alirezaiyan.data.di

import dagger.Binds
import dagger.Module
import ir.alirezaiyan.data.mapper.Mapper
import ir.alirezaiyan.data.model.*
import ir.alirezaiyan.data.remote.response.VenueResponse

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 5/2/2020 2:38 AM.
 */
@Module
interface MapperModule {

    @Binds
    fun venuesEntityModelMapper(
        mapper: VenuesEntityModelMapper
    ): Mapper<VenueResponse, VenueEntity>

    @Binds
    fun venuesUiModelMapper(
        mapper: VenuesUiModelMapper
    ): Mapper<VenueResponse, VenueUiModel>

    @Binds
    fun venueUiModelMapper(
        mapper: VenueUiModelMapper
    ): Mapper<VenueEntity, VenueUiModel>

}