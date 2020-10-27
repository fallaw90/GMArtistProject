package com.fall.gmartistproject.services

import com.fall.gmartistproject.models.ArtistData
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

/**
 * Interface for API call
 */
interface ApiInterface {
    @GET
    fun getData(@Url url: String?): Call<ArtistData>?
}