package com.fall.gmartistproject.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.fall.gmartistproject.models.ApiResponse
import com.fall.gmartistproject.models.ArtistData
import com.fall.gmartistproject.repositories.ArtistRepository


class ArtistViewModel: ViewModel() {

    companion object{
        var artistData: ArtistData? = null
    }

    fun getArtistData(artistName: String): LiveData<ApiResponse> {
        return ArtistRepository.getArtistData(artistName)
    }
}