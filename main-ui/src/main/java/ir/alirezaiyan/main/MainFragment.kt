package ir.alirezaiyan.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import ir.alirezaiyan.main.databinding.MainFragmentBinding
import ir.alirezaiyan.main.utils.EndlessOnScrollListener
import ir.alirezaiyan.sdk.ui.BaseFragment
import javax.inject.Inject

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 4/29/2020 10:40 PM.
 */
class MainFragment : BaseFragment() {

    @Inject
    lateinit var vm: MainViewModel

    private lateinit var binding: MainFragmentBinding

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

        val exploreAdapter = ExploreAdapter()
        binding.exploreList.apply {
            addOnScrollListener(endlessScroll)
            adapter = exploreAdapter
        }

        endlessScroll.onLoadMore()

        vm.venueLiveData().observe(viewLifecycleOwner,
            Observer { exploreAdapter.update(it) })

        vm.stateLiveData().observe(viewLifecycleOwner,
            Observer { updateProgress(it) })
    }

}