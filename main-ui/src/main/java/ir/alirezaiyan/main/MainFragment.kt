package ir.alirezaiyan.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ir.alirezaiyan.main.databinding.MainFragmentBinding
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = vm
        return binding.root
    }


}