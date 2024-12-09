package com.bignerdranch.andriod.nasaapi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bignerdranch.andriod.nasaapi.api.NasaResponse
import coil.load
import com.bignerdranch.andriod.nasaapi.databinding.FragmentSinglePhotoBinding


class SinglePhotoFragment : Fragment() {

    private var _binding: FragmentSinglePhotoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSinglePhotoBinding.inflate(inflater, container, false)

        val selectedPhoto = arguments?.<NasaResponse>("selected_photo")

        selectedPhoto?.let {
            binding.photoImageView.load(it.url)
            binding.photoTitle.text = it.title
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
