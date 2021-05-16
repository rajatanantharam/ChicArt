package io.chicago.art.artwork.view

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import io.chicago.art.artwork.dto.ui.ArtWorkUIItem

internal class ArtWorkPagerAdapter(fa: Fragment, private val artWorks: List<ArtWorkUIItem>) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = artWorks.size
    override fun createFragment(position: Int): Fragment = ArtWorkFragment.newInstance(artWorks[position])
}