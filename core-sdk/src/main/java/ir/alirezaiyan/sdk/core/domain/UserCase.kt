package ir.alirezaiyan.sdk.core.domain

import ir.alirezaiyan.sdk.core.utils.Either
import ir.alirezaiyan.sdk.core.utils.Failure
import kotlinx.coroutines.*

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 4/30/2020 3:50 PM.
 */
abstract class UseCase<out Type, in Params> where Type : Any {

    private val mainJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + mainJob)

    abstract suspend fun run(params: Params): Either<Failure, Type>

    operator fun invoke(params: Params, onResult: (Either<Failure, Type>) -> Unit = {}) {
        uiScope.launch { onResult(withContext(Dispatchers.IO) { run(params) }) }
    }

    fun cancel() {
        mainJob.cancel()
    }

}