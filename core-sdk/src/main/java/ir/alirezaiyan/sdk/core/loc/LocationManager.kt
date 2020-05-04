package ir.alirezaiyan.sdk.core.loc

import android.app.Activity
import com.google.android.gms.location.*

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 5/1/2020 10:11 PM.
 */
private const val UPDATE_INTERVAL_IN_MILLISECONDS: Long = 1000 * 60 * 1; // 1 minute
private const val MIN_DISTANCE_CHANGE_FOR_UPDATES: Float = 100F;
const val LOCATION_PERMISSION_REQ = 113
const val GOOGLE_PLAY_SERVICES_UPDATE_REQ = 65538
const val ENABLE_GPS_REQ = 102

class LocationManager(
    private val activity: Activity,
    private val locationUpdateListener: LocationUpdate
) {

    private lateinit var mLocationRequest: LocationRequest
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var locationCallback: LocationCallback

    init {
        initLocationProvider()
    }

    private fun initLocationProvider() {
        mLocationRequest = LocationRequest()
        mLocationRequest.interval = UPDATE_INTERVAL_IN_MILLISECONDS
        // we won't to have a accurate location because to save battery power use this flag
        mLocationRequest.priority = LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY
        mLocationRequest.smallestDisplacement = MIN_DISTANCE_CHANGE_FOR_UPDATES
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(activity)

        fusedLocationClient.lastLocation
            .addOnSuccessListener(activity) { location ->

                if (location != null) {
                    locationUpdateListener.updateLocation(location)
                }
            }

        locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult?) {
                if (locationResult == null) {
                    return
                }
                locationUpdateListener.updateLocation(locationResult.lastLocation)
            }
        }
    }

    fun start() {
        fusedLocationClient.requestLocationUpdates(mLocationRequest, locationCallback, null)
    }

    fun stop() {
        fusedLocationClient.removeLocationUpdates(locationCallback)
    }

}