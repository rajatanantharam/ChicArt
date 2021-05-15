package io.chicago.art.collection.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.chicago.art.databinding.CollectionFragmentBinding

class CollectionFragment: Fragment() {

    private lateinit var binding: CollectionFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = CollectionFragmentBinding.inflate(inflater, container, false).also {
        binding = it
    }.root
}