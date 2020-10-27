package com.fall.gmartistproject.services

import com.fall.gmartistproject.utils.Constants
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

object ApiClient {

    fun getClient(): Retrofit? {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}