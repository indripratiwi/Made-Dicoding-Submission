package com.application.moviecatalogue.ui.tvshow

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
import com.application.moviecatalogue.core.ui.TvShowAdapter
import com.application.moviecatalogue.databinding.FragmentTvShowBinding
import com.application.moviecatalogue.ui.detail.DetailActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvShowFragment : Fragment() {

    private val tvShowViewModel: TvShowViewModel by viewModels()

    private lateinit var adapter: TvShowAdapter
    private lateinit var binding: FragmentTvShowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTvShowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvShowViewModel.tvShow.observe(viewLifecycleOwner,{ tvShowList ->
            if (tvShowList != null) {
                when (tvShowList) {
                    is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        binding.rvItem.adapter?.let { adapter ->
                            when (adapter) {
                                is TvShowAdapter -> {
                                    tvShowList.data?.let { adapter.setData(it) }
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
            intent.putExtra(DetailActivity.EXTRA_TV_SHOW, selectedData)
            startActivity(intent)
        }
    }

    private fun showRecyclerList() {
        adapter = TvShowAdapter()
        binding.rvItem.layoutManager = GridLayoutManager(activity, 2)
        binding.rvItem.adapter = adapter
    }
}