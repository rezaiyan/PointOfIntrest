package ir.alirezaiyan.sdk.core.utils

import android.location.Location

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 5/1/2020 10:46 PM.
 */
fun Location.get() = "${this.latitude},${this.longitude}"