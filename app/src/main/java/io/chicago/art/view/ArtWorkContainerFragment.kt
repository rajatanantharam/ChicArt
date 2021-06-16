package io.chicago.art.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.chicago.art.databinding.ArtworkContainerFragmentBinding
import io.chicago.art.viewmodel.ArtWorkViewModel
import io.chicago.data.mappers.ArtWorkMapper.getArtworkUIItems
import io.chicago.domain.common.DefaultViewState
import org.koin.androidx.viewmodel.ext.android.viewModel

class ArtWorkContainerFragment: Fragment() {

    private val artWorkViewModel: ArtWorkViewModel by viewModel()
    private lateinit var binding: ArtworkContainerFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = ArtworkContainerFragmentBinding.inflate(inflater, container, false).also {
        binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        artWorkViewModel.artWorks.observe(viewLifecycleOwner, {
            if (it is DefaultViewState.Success) {
                binding.pager.adapter = ArtWorkPagerAdapter(this, getArtworkUIItems(it.result))
            }
        })
    }
}