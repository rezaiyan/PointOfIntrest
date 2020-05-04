package ir.alirezaiyan.sdk.core.utils

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 4/30/2020 3:47 PM.
 */
sealed class Failure {
    object NetworkConnection : Failure()
    object ServerError : Failure()
    object NotFound : Failure()
}