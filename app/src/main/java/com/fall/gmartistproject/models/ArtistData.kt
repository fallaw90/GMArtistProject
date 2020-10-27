package com.fall.gmartistproject.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ArtistData(
    @SerializedName("resultCount")
    val resultCount: Int,
    @SerializedName("results")
    val results: List<Artist>
) : Serializable