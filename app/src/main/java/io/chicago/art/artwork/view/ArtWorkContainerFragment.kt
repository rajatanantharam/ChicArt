package io.chicago.art.artwork.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.chicago.art.databinding.ArtworkContainerFragmentBinding

class ArtWorkContainerFragment: Fragment() {

    private lateinit var binding: ArtworkContainerFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = ArtworkContainerFragmentBinding.inflate(inflater, container, false).also {
        binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.pager.adapter = ArtWorkPagerAdapter(this)
    }
}