package com.fall.gmartistproject.views.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.fall.gmartistproject.R
import com.fall.gmartistproject.adapters.ArtistAdapter
import com.fall.gmartistproject.viewmodels.ArtistViewModel
import kotlinx.android.synthetic.main.activity_list_items.*


class ListItemsActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_items)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Home"

        //adding a layoutmanager
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        //creating our adapter
        val adapter = ArtistViewModel.artistData?.let { ArtistAdapter(it) }

        //now adding the adapter to recyclerview
        recyclerView.adapter = adapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}