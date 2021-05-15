package io.chicago.art.collection.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.chicago.art.databinding.CollectionContainerFragmentBinding

class CollectionContainerFragment: Fragment() {

    private lateinit var binding: CollectionContainerFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = CollectionContainerFragmentBinding.inflate(inflater, container, false).also {
        binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.pager.adapter = CollectionPagerAdapter(this)
    }
}