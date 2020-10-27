package com.fall.gmartistproject.models

import com.google.gson.annotations.SerializedName

/**
 * Response API object
 */
data class ArtistData(
    @SerializedName("resultCount")
    val resultCount: Int,
    @SerializedName("results")
    val results: List<Artist>
)