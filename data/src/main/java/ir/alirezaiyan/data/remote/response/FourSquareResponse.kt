package ir.alirezaiyan.data.remote.response

data class FourSquareResponse<out T>(val meta: MetaResponse, val response: Response<T>)
