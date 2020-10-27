package com.fall.gmartistproject.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fall.gmartistproject.models.ApiResponse
import com.fall.gmartistproject.models.ArtistData
import com.fall.gmartistproject.models.ErrorObject
import com.fall.gmartistproject.services.ApiClient.getClient
import com.fall.gmartistproject.services.ApiInterface
import com.fall.gmartistproject.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * This object is fetching data from API and return it as a LiveData Object
 */
object ArtistRepository {

    private const val TAG = "ArtistRepository"

    private val apiResponseLiveData: MutableLiveData<ApiResponse> = MutableLiveData<ApiResponse>()
    private var apiResponse: ApiResponse? = null

    /**
     * Return all artist data found as a live data object
     * @param artistName
     */
    fun getArtistData(artistName: String): LiveData<ApiResponse> {
        getData(artistName)
        return apiResponseLiveData
    }

    /**
     * Perform Api call and get data onSuccess or onFailure
     * @param artistName
     */
    private fun getData(artistName: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val apiInterface = getClient()?.create(ApiInterface::class.java)
            val call: Call<ArtistData>? =
                apiInterface?.getData(Constants.BASE_URL + Constants.SEARCH_END_POINT + artistName)
            call?.enqueue(object : Callback<ArtistData?> {
                override fun onResponse(call: Call<ArtistData?>?, response: Response<ArtistData?>) {
                    if (response.body() != null) {
                        apiResponse = ApiResponse(response.body(), true, null)
                        apiResponseLiveData.postValue(apiResponse)
                    }
                }

                override fun onFailure(call: Call<ArtistData?>?, t: Throwable) {
                    Log.d(TAG, t.message)
                    val errorObject = ErrorObject("My error code", t.message)
                    apiResponse = ApiResponse(null, false, errorObject)
                    apiResponseLiveData.postValue(apiResponse)
                }
            })
        }
    }

}