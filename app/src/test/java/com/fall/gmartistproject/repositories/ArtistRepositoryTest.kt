package com.fall.gmartistproject.repositories

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.fall.gmartistproject.models.ApiResponse
import com.fall.gmartistproject.models.ArtistData
import com.fall.gmartistproject.viewmodels.ArtistViewModel
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito

@RunWith(JUnit4::class)
class ArtistRepositoryTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private lateinit var artistRepository: ArtistRepository
    private lateinit var apiResponse: ApiResponse
    private lateinit var artistData: ArtistData
    private val apiResponseLiveData = MutableLiveData<ApiResponse>()

    @Before
    fun setUp() {
        artistRepository = Mockito.mock(ArtistRepository::class.java)
        artistData = ArtistData(0, emptyList())
    }

    @Test
    fun testGetArtistDataWithStringValue(){

        apiResponse = ApiResponse(artistData, true, null)
        apiResponseLiveData.value = apiResponse

        Mockito.`when`(artistRepository.getArtistData("Akon"))
            .thenReturn(apiResponseLiveData)

        artistRepository.getArtistData("Akon")

        assert(apiResponseLiveData.value!!.isSuccess)
    }

    @Test
    fun testGetArtistDataWithEmptyString(){

        apiResponse = ApiResponse(artistData, true, null)
        apiResponseLiveData.value = apiResponse

        Mockito.`when`(artistRepository.getArtistData(""))
            .thenReturn(apiResponseLiveData)

        artistRepository.getArtistData("")

        assert(apiResponseLiveData.value!!.artistData?.results!!.isEmpty())
    }
}