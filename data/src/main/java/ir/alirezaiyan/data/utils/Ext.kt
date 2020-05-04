package ir.alirezaiyan.data.utils

import ir.alirezaiyan.data.model.Range

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

private const val radios = 100
fun Pair<Double, Double>.getRange() =
    Range(first - radios, first + radios, second - radios, second + radios)