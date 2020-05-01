package ir.alirezaiyan.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import dagger.android.support.DaggerFragment
import ir.alirezaiyan.data.model.VenueUiModel
import ir.alirezaiyan.detail.databinding.DetailFragmentBinding
import kotlinx.android.synthetic.main.detail_fragment.*


/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 4/30/2020 12:21 PM.
 */
class DetailFragment : DaggerFragment() {

    private lateinit var binding: DetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(arguments?.get("venue") as VenueUiModel) {
            detailsTitle.text = title
            detailsAddress.text = formattedAddress
            detailsRateTitle.text = rating.toString()
            if (photoUrl.isNotEmpty())
                Picasso.get().load(photoUrl).into(detailsPoster)
        }

    }
}