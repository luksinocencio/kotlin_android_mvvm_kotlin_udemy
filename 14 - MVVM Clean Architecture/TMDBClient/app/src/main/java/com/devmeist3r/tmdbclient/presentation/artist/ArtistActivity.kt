package com.devmeist3r.tmdbclient.presentation.artist

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
import com.devmeist3r.tmdbclient.databinding.ActivityArtistBinding
import com.devmeist3r.tmdbclient.presentation.di.Injector
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {
  @Inject
  lateinit var factory: ArtistViewModelFactory

  private lateinit var artistViewModel: ArtistViewModel
  private lateinit var binding: ActivityArtistBinding
  private lateinit var adapter: ArtistAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)

    (application as Injector).createArtistSubComponent()
      .inject(this)

    artistViewModel = ViewModelProvider(this, factory)
      .get(ArtistViewModel::class.java)

    initRecyclerView()
  }

  private fun initRecyclerView() {
    binding.artistRecyclerView.layoutManager = LinearLayoutManager(this)
    adapter = ArtistAdapter()
    binding.artistRecyclerView.adapter = adapter
    displayPopularMovies()
  }

  private fun displayPopularMovies() {
    binding.artistProgressBar.visibility = View.VISIBLE
    val responseLiveData = artistViewModel.getArtists()

    responseLiveData.observe(this, Observer {
      Log.i("MYTAG", it.toString())
      if (it != null) {
        adapter.setList(it)
        adapter.notifyDataSetChanged()
        binding.artistProgressBar.visibility = View.GONE
      } else {
        binding.artistProgressBar.visibility = View.VISIBLE
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
    binding.artistProgressBar.visibility = View.VISIBLE
    val response = artistViewModel.updateArtists()
    response.observe(this, Observer {
      if (it != null) {
        adapter.setList(it)
        adapter.notifyDataSetChanged()
        binding.artistProgressBar.visibility = View.GONE
      } else {
        binding.artistProgressBar.visibility = View.GONE
        Log.e("MYTAG", "updateMovies: Erro update data")
      }
    })
  }

}
