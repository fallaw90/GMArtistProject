package com.fall.gmartistproject.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fall.gmartistproject.R
import com.fall.gmartistproject.models.Artist
import com.fall.gmartistproject.models.ArtistData

class ArtistAdapter(private val artistData: ArtistData): RecyclerView.Adapter<ArtistAdapter.ArtistHolder>() {

    private val results = artistData.results

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ArtistHolder(v)
    }
    override fun getItemCount(): Int {
        return results.size
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: ArtistHolder, position: Int) {
        holder.bindItems(results[position])
    }

    //the class is hodling the list view
    class ArtistHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(artist: Artist) {
            val textViewArtistName = itemView.findViewById(R.id.tv_artist_name) as TextView
            val textViewTrackName = itemView.findViewById(R.id.tv_track_name) as TextView
            val textViewReleaseDate = itemView.findViewById(R.id.tv_release_date) as TextView
            val textViewPrimaryGenreName = itemView.findViewById(R.id.tv_primary_genre_name) as TextView
            val textViewTrackPrice = itemView.findViewById(R.id.tv_track_price) as TextView
            textViewArtistName.text = artist.artistName
            textViewTrackName.text = artist.trackName
            textViewReleaseDate.text = artist.releaseDate
            textViewPrimaryGenreName.text = artist.primaryGenreName
            textViewTrackPrice.text = artist.trackPrice.toString()
        }
    }

}