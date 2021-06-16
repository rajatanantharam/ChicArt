package io.chicago.art.view

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import io.chicago.data.entities.ArtWorkUIItem

internal class ArtWorkPagerAdapter(fa: Fragment, private val artWorks: List<ArtWorkUIItem>) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = artWorks.size
    override fun createFragment(position: Int): Fragment = ArtWorkFragment.newInstance(artWorks[position])
}