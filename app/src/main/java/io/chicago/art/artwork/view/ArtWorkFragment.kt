package io.chicago.art.artwork.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import io.chicago.art.artwork.dto.ui.ArtWorkUIItem
import io.chicago.art.databinding.ArtworkFragmentBinding

class ArtWorkFragment : Fragment() {

    private lateinit var binding: ArtworkFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = ArtworkFragmentBinding.inflate(inflater, container, false).also {
        binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val artwork = arguments?.getParcelable<ArtWorkUIItem>(ARTWORK_UI_ITEM) ?: return
        binding.artwork = artwork
    }

    companion object {
        private const val ARTWORK_UI_ITEM = "artwork"
        fun newInstance(artWorkUIItem: ArtWorkUIItem) = ArtWorkFragment().apply {
            arguments = bundleOf(ARTWORK_UI_ITEM to artWorkUIItem)
        }
    }
}