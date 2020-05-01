package ir.alirezaiyan.detail

import ir.alirezaiyan.data.Repository
import ir.alirezaiyan.sdk.core.domain.UseCase
import ir.alirezaiyan.sdk.core.utils.Either
import ir.alirezaiyan.sdk.core.utils.Failure
import ir.alirezaiyan.sdk.core.utils.None
import javax.inject.Inject

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 4/30/2020 12:33 PM.
 */
class DetailUseCase @Inject constructor(private val repository: Repository) :
    UseCase<None, String>() {
    override suspend fun run(params: String): Either<Failure, None> = repository.getVenue(params)
}