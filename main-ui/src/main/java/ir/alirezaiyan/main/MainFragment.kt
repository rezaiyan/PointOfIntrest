package ir.alirezaiyan.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import ir.alirezaiyan.data.model.VenueUiModel
import ir.alirezaiyan.main.databinding.MainFragmentBinding
import ir.alirezaiyan.main.utils.EndlessOnScrollListener
import ir.alirezaiyan.main.utils.ItemClick
import ir.alirezaiyan.sdk.ui.BaseFragment
import ir.alirezaiyan.sdk.ui.core.NavigationController
import javax.inject.Inject

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 4/29/2020 10:40 PM.
 */
class MainFragment : BaseFragment() {

    @Inject
    lateinit var vm: MainViewModel

    @Inject
    lateinit var navigator: NavigationController

    private lateinit var binding: MainFragmentBinding

    private val exploreAdapter = ExploreAdapter(object : ItemClick<VenueUiModel> {
        override fun click(item: VenueUiModel) {
            val bundle = bundleOf("venue" to item)
            navigator.navigateToDetail(this@MainFragment, bundle)
        }
    })

    private val endlessScroll = object : EndlessOnScrollListener() {
        override fun onLoadMore() {
            vm.getVenues(binding.exploreList.adapter?.itemCount.toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = vm
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.exploreList.apply {
            addOnScrollListener(endlessScroll)
            adapter = exploreAdapter
        }

        if (exploreAdapter.itemCount == 0) vm.getVenues()

        vm.venueLiveData().observe(viewLifecycleOwner,
            Observer { exploreAdapter.update(it) })

        vm.stateLiveData().observe(viewLifecycleOwner,
            Observer { updateProgress(it) })
    }

}