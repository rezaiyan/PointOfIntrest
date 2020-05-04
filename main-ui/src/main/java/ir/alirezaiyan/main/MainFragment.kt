package ir.alirezaiyan.main

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.PermissionChecker
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import ir.alirezaiyan.data.model.VenueUiModel
import ir.alirezaiyan.main.databinding.MainFragmentBinding
import ir.alirezaiyan.main.utils.EndlessOnScrollListener
import ir.alirezaiyan.main.utils.ItemClick
import ir.alirezaiyan.main.utils.visibleOrGone
import ir.alirezaiyan.sdk.core.loc.*
import ir.alirezaiyan.sdk.core.utils.Failure
import ir.alirezaiyan.sdk.core.utils.get
import ir.alirezaiyan.sdk.ui.BaseFragment
import ir.alirezaiyan.sdk.ui.core.NavigationController
import kotlinx.android.synthetic.main.main_fragment.*
import javax.inject.Inject

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 4/29/2020 10:40 PM.
 */
class MainFragment : BaseFragment(), LocationUpdate {

    private val locationManager: LocationManager by lazy {
        LocationManager(requireActivity(), this)
    }

    @Inject
    lateinit var vm: MainViewModel
    @Inject
    lateinit var navigator: NavigationController
    private lateinit var location: Location
    private lateinit var binding: MainFragmentBinding
    private var needUpdateList = true

    private val exploreAdapter = ExploreAdapter(object : ItemClick<VenueUiModel> {
        override fun click(item: VenueUiModel) {
            navigator.navigateToDetail(this@MainFragment, bundleOf("venueID" to item.id))
        }
    })

    private val endlessScroll = object : EndlessOnScrollListener() {
        override fun onLoadMore() {
            vm.getVenues(location.get(), binding.exploreList.adapter?.itemCount.toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = vm
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        if (exploreAdapter.itemCount == 0) {
            loadVenues()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.exploreList.apply {
            addOnScrollListener(endlessScroll)
            adapter = exploreAdapter
        }
        vm.venueLiveData().observe(viewLifecycleOwner,
            Observer {
                if (needUpdateList) {
                    exploreAdapter.update(it)
                    emptyView.visibleOrGone = exploreAdapter.itemCount == 0
                }
                needUpdateList = true
            })

        vm.stateLiveData().observe(viewLifecycleOwner,
            Observer {
                updateProgress(it)
                emptyView.visibleOrGone = !it && exploreAdapter.itemCount == 0
            })

        vm.failureLiveData().observe(
            viewLifecycleOwner,
            Observer {
                val errorMessage: String = when (it) {
                    is Failure.NetworkConnection -> getString(R.string.network_connection_alert)
                    is Failure.ServerError -> getString(R.string.server_error_alert)
                    else -> getString(R.string.unknown_error)
                }
                navigator.showError(requireActivity(), errorMessage)
                endlessScroll.onFailure()
                needUpdateList = true
            })
    }

    private fun loadVenues() {
        if (exploreAdapter.itemCount == 0) {
            if (::location.isInitialized) {
                vm.getVenues(location.get())
            } else {
                showMessage(getString(R.string.waiting_alert))
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        needUpdateList = false
    }

    override fun onStart() {
        super.onStart()
        checkPermission()
    }

    override fun onStop() {
        super.onStop()
        locationManager.stop()
    }

    override fun updateLocation(loc: Location) {
        location = loc
        exploreAdapter.clear()
        vm.getVenues(location.get())
    }

    private fun checkPermission() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
            PermissionChecker.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PermissionChecker.PERMISSION_GRANTED &&
            PermissionChecker.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PermissionChecker.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ), LOCATION_PERMISSION_REQ
            )
        } else {
            locationManager.start()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (ActivityCompat.shouldShowRequestPermissionRationale(
                requireActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) &&
            ActivityCompat.shouldShowRequestPermissionRationale(
                requireActivity(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        ) {
            checkPermission()
        } else {
            if (ActivityCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                locationManager.start()
            } else {
                openSetting(LOCATION_PERMISSION_REQ)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            GOOGLE_PLAY_SERVICES_UPDATE_REQ -> {
                showMessage(getString(R.string.google_play_service_update_alert))
            }
            ENABLE_GPS_REQ -> {
                if (resultCode == 0) {
                    showMessage(getString(R.string.gps_alert))
                }
            }
            LOCATION_PERMISSION_REQ -> {
                checkPermission()
            }
        }
    }

}