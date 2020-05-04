package ir.alirezaiyan.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.squareup.picasso.Picasso
import dagger.android.support.DaggerFragment
import ir.alirezaiyan.detail.databinding.DetailFragmentBinding
import ir.alirezaiyan.sdk.core.utils.Failure
import ir.alirezaiyan.sdk.ui.core.NavigationController
import kotlinx.android.synthetic.main.detail_fragment.*
import javax.inject.Inject


/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 4/30/2020 12:21 PM.
 */
class DetailFragment : DaggerFragment() {

    private lateinit var binding: DetailFragmentBinding
    @Inject
    lateinit var viewModel: DetailViewModel
    @Inject
    lateinit var navigator: NavigationController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getVenue(arguments?.getString("venueID")!!)

        viewModel.venueLiveData().observe(viewLifecycleOwner,
            Observer {
                with(it) {
                    detailsTitle.text = title
                    detailsAddress.text = formattedAddress
                    detailsRateTitle.text = rating.toString()
                    if (photoUrl.isNotEmpty())
                        Picasso.get().load(photoUrl).into(detailsPoster)
                }
            })

        viewModel.failureLiveData().observe(viewLifecycleOwner,
            Observer {
                val errorMessage: String = when (it) {
                    is Failure.NetworkConnection -> getString(R.string.network_connection_alert)
                    is Failure.ServerError -> getString(R.string.server_error_alert)
                    is Failure.NotFound -> getString(R.string.unknown_error)
                }
                navigator.showError(requireActivity(), errorMessage)
            })

    }
}