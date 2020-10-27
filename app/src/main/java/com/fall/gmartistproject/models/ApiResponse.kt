package com.fall.gmartistproject.models

data class ApiResponse(
    val artistData: ArtistData?,
    val isSuccess: Boolean,
    val errorObject: ErrorObject?
)