package ir.alirezaiyan.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import ir.alirezaiyan.detail.databinding.DetailFragmentBinding


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
}