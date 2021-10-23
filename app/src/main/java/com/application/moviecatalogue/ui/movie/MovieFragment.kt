package com.application.moviecatalogue.ui.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.application.moviecatalogue.core.data.Resource
import com.application.moviecatalogue.core.ui.MovieAdapter
import com.application.moviecatalogue.databinding.FragmentMovieBinding
import com.application.moviecatalogue.ui.detail.DetailActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieFragment : Fragment() {

    private val movieViewModel: MovieViewModel by viewModels()

    private lateinit var adapter: MovieAdapter
    private lateinit var binding: FragmentMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieViewModel.movie.observe(viewLifecycleOwner,{ movieList ->
            if (movieList != null) {
                when (movieList) {
                    is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        binding.rvItem.adapter?.let { adapter ->
                            when (adapter) {
                                is MovieAdapter -> {
                                    movieList.data?.let { adapter.setData(it) }
                                    adapter.notifyDataSetChanged()
                                }
                            }
                        }
                    }
                    is Resource.Error -> {
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(context, "Check your internet connection", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
        binding.progressBar.visibility = View.VISIBLE
        showRecyclerList()

        adapter.onItemClick = { selectedData ->
            val intent = Intent(activity, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_MOVIE, selectedData)
            startActivity(intent)
        }
    }

    private fun showRecyclerList() {
        adapter = MovieAdapter()
        binding.rvItem.layoutManager = GridLayoutManager(activity, 2)
        binding.rvItem.adapter = adapter
    }
}