package ir.alirezaiyan.data.remote.response

data class FoursquareResponse<out T>(val meta: MetaResponse, val response: Response<T>)
