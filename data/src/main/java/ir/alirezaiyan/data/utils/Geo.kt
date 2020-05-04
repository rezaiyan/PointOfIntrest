package ir.alirezaiyan.data.utils

import kotlin.math.ln
import kotlin.math.tan

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 5/4/2020 3:12 AM.
 */
//Helper methods to convert 4326 to 3852
const val RADIUS: Double = 6378137.0 /* in meters on the equator */

fun Double.toY(): Double {
    return ln(tan(Math.PI / 4 + Math.toRadians(this) / 2)) * RADIUS
}

fun Double.toX(): Double {
    return Math.toRadians(this) * RADIUS
}