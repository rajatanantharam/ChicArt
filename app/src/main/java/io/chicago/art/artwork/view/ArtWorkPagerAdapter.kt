package io.chicago.art.artwork.view

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

internal class ArtWorkPagerAdapter(fa: Fragment) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = 50
    override fun createFragment(position: Int): Fragment = ArtWorkFragment()
}