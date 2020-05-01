package ir.alirezaiyan.sdk.core.loc

import android.location.Location

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 5/1/2020 10:11 PM.
 */
interface LocationUpdate {

    fun updateLocation(loc: Location)

}
