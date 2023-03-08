package com.wolox.openpaytechdemo.ui.upload

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.wolox.openpaytechdemo.databinding.FragmentLocationsBinding
import com.wolox.openpaytechdemo.databinding.FragmentUploadBinding
import com.wolox.openpaytechdemo.ui.locations.LocationViewModel

class UploadFragment : Fragment(){

    private lateinit var binding: FragmentUploadBinding
    private val viewModel : UploadViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = FragmentUploadBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root
}