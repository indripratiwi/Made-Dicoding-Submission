package com.application.moviecatalogue.favorites.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.application.moviecatalogue.databinding.FragmentFavoriteBinding

class FavoriteFragment : Fragment() {
    private lateinit var binding: FragmentFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, childFragmentManager)
        binding.viewPager.adapter = sectionsPagerAdapter
        binding.tabs.setupWithViewPager(binding.viewPager)
    }
}