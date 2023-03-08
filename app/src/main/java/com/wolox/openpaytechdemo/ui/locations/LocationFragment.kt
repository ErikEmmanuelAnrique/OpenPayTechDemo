package com.wolox.openpaytechdemo.ui.locations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.wolox.openpaytechdemo.databinding.FragmentLocationsBinding

class LocationFragment : Fragment() {

    private lateinit var binding: FragmentLocationsBinding
    private val viewModel : LocationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = FragmentLocationsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root
}
