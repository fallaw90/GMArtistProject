package com.fall.gmartistproject.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.fall.gmartistproject.models.ApiResponse
import com.fall.gmartistproject.models.ArtistData
import com.fall.gmartistproject.repositories.ArtistRepository
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

@RunWith(JUnit4::class)
class ArtistViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()
    
    private lateinit var artistViewModel: ArtistViewModel
    private lateinit var artistRepository: ArtistRepository
    private lateinit var apiResponse: ApiResponse   
    private lateinit var artistData: ArtistData
    private val apiResponseLiveData = MutableLiveData<ApiResponse>()
    
    @Before
    fun setUp() {
        artistViewModel = ArtistViewModel()
        artistRepository = mock(ArtistRepository::class.java)
        artistData = ArtistData(0, emptyList())
    }

    @Test
    fun testGetArtistDataWithStringValue(){

        apiResponse = ApiResponse(artistData, true, null)
        apiResponseLiveData.value = apiResponse

        `when`(artistRepository.getArtistData("Akon"))
            .thenReturn(apiResponseLiveData)

        artistViewModel.getArtistData("Akon")

        assert(apiResponseLiveData.value!!.isSuccess)
    }

    @Test
    fun testGetArtistDataWithEmptyString(){

        apiResponse = ApiResponse(artistData, true, null)
        apiResponseLiveData.value = apiResponse

        `when`(artistRepository.getArtistData(""))
            .thenReturn(apiResponseLiveData)

        artistViewModel.getArtistData("")

        assert(apiResponseLiveData.value!!.artistData?.results!!.isEmpty())
    }
}