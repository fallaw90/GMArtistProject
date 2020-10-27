package com.fall.gmartistproject.services

import com.fall.gmartistproject.models.ArtistData
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url


interface ApiInterface {

    @GET
    fun getData(@Url url: String?): Call<ArtistData>?

    /*@GET("search?term=")
    fun getData(@Query("name") name: String?):  Call<ArtistData>?*/
}