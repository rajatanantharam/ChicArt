package io.chicago.art.artwork.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.chicago.art.databinding.ArtworkFragmentBinding

class ArtWorkFragment: Fragment() {

    private lateinit var binding: ArtworkFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = ArtworkFragmentBinding.inflate(inflater, container, false).also {
        binding = it
    }.root
}