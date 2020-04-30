package ir.alirezaiyan.data.remote.response

data class Response<out T>(val groups: List<GroupsResponse<T>>)
