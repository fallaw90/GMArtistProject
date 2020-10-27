package com.fall.gmartistproject.views.activities

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.fall.gmartistproject.R
import com.fall.gmartistproject.viewmodels.ArtistViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var artistViewModel: ArtistViewModel
    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Home"

        initProgressDialog()

        artistViewModel = ViewModelProvider(this).get(ArtistViewModel::class.java)
        setClickListener()
    }

    /**
     * Set the search button click listener and call the function that trigger the API call
     */
    private fun setClickListener() {
        btn_search.setOnClickListener {
            val artistName = et_artist_name.text.toString()
            if (artistName.isBlank()) {
                et_artist_name.error = "Field required!"
                et_artist_name.requestFocus()
            } else {
                observeArtistData(artistName)
            }
        }
    }

    /**
     * Trigger the API call and observe the return value
     * @param artistName
     */
    private fun observeArtistData(artistName: String) {
        progressDialog.show()
        artistViewModel.getArtistData(artistName).observe(this@MainActivity, Observer {
            progressDialog.dismiss()
            if (it.isSuccess) {
                ArtistViewModel.artistData = it.artistData
                startActivity(Intent(this@MainActivity, ListItemsActivity::class.java))
            } else {
                Toast.makeText(this@MainActivity, "API Call Fail", Toast.LENGTH_LONG).show()
                Toast.makeText(this@MainActivity, "Data: ${it.artistData}", Toast.LENGTH_LONG)
                    .show()
            }
        })
    }

    /**
     * Initialize the loading indicator
     */
    private fun initProgressDialog(){
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Loading")
        progressDialog.setMessage("Wait while loading...")
        progressDialog.setCancelable(false)
    }
}