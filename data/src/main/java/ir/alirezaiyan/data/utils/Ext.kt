package ir.alirezaiyan.data.utils

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 5/2/2020 3:17 AM.
 */
fun String.getLatitude(): Double {
    return this.split(",")[0].toDouble()
}

fun String.getLongitude(): Double {
    return this.split(",")[1].toDouble()
}