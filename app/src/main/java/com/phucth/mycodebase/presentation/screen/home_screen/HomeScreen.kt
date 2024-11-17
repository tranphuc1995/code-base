package com.phucth.mycodebase.presentation.screen.home_screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.phucth.base.fragment.FragmentBase
import com.phucth.mycodebase.databinding.HomeFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeScreen : FragmentBase<HomeFragmentBinding>(HomeFragmentBinding::inflate) {

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding?.tvTest?.setOnClickListener {
            backToPreviousScreen()
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                homeViewModel.state.collect { listFilmModelUi ->
                    println("${listFilmModelUi.size}")
                }
            }
        }

        homeViewModel.getData()
    }
}