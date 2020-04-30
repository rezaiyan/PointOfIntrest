package ir.alirezaiyan.data.remote.response

data class GroupsResponse<out T>(val items: List<T>)