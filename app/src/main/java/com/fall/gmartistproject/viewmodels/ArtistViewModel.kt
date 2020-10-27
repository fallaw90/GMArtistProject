package com.fall.gmartistproject.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.fall.gmartistproject.models.ApiResponse
import com.fall.gmartistproject.models.ArtistData
import com.fall.gmartistproject.repositories.ArtistRepository

/**
 * This ViewModel object get a reference from the repository and return data fetched from API
 */
class ArtistViewModel: ViewModel() {

    companion object{
        var artistData: ArtistData? = null
    }

    /**
     * Get all collection data from API
     * @param artistName
     */
    fun getArtistData(artistName: String): LiveData<ApiResponse> {
        return ArtistRepository.getArtistData(artistName)
    }
}