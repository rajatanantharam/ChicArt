package io.chicago.art.collection.view

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

internal class CollectionPagerAdapter(fa: Fragment) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = 50
    override fun createFragment(position: Int): Fragment = CollectionFragment()
}