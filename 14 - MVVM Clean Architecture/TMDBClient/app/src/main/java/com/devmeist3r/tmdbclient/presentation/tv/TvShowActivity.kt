package com.devmeist3r.tmdbclient.presentation.tv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.devmeist3r.tmdbclient.R
import com.devmeist3r.tmdbclient.databinding.ActivityTvShowBinding
import com.devmeist3r.tmdbclient.presentation.di.Injector
import javax.inject.Inject

class TvShowActivity : AppCompatActivity() {

  @Inject
  lateinit var factory: TvShowViewModelFactory

  private lateinit var tvShowViewModel: TvShowViewModel
  private lateinit var binding: ActivityTvShowBinding
  private lateinit var adapter: TvShowAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)

    (application as Injector).createTvShowSubComponent()
      .inject(this)

    tvShowViewModel = ViewModelProvider(this, factory)
      .get(TvShowViewModel::class.java)

    initRecyclerView()
  }

  private fun initRecyclerView() {
    binding.tvShowRecyclerView.layoutManager = LinearLayoutManager(this)
    adapter = TvShowAdapter()
    binding.tvShowRecyclerView.adapter = adapter
    displayPopularMovies()
  }

  private fun displayPopularMovies() {
    binding.tvShowProgressBar.visibility = View.VISIBLE
    val responseLiveData = tvShowViewModel.getTvShows()

    responseLiveData.observe(this, Observer {
      Log.i("MYTAG", it.toString())
      if (it != null) {
        adapter.setList(it)
        adapter.notifyDataSetChanged()
        binding.tvShowProgressBar.visibility = View.GONE
      } else {
        binding.tvShowProgressBar.visibility = View.VISIBLE
        Toast.makeText(this, "No avaliable data", Toast.LENGTH_LONG).show()
      }
    })
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    val inflater: MenuInflater = menuInflater
    inflater.inflate(R.menu.update, menu)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {

    return when (item.itemId) {
      R.id.action_update -> {
        this.updateMovies()
        return true
      }
      else -> super.onOptionsItemSelected(item)
    }
  }

  private fun updateMovies() {
    binding.tvShowProgressBar.visibility = View.VISIBLE
    val response = tvShowViewModel.updateTvShows()
    response.observe(this, Observer {
      if (it != null) {
        adapter.setList(it)
        adapter.notifyDataSetChanged()
        binding.tvShowProgressBar.visibility = View.GONE
      } else {
        binding.tvShowProgressBar.visibility = View.GONE
        Log.e("MYTAG", "updateMovies: Erro update data")
      }
    })
  }

}
