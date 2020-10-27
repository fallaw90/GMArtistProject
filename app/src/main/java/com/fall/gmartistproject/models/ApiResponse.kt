package com.fall.gmartistproject.models

/**
 * This object hold the response data from API
 * A flag that tells if the API call success or not
 * An object that hold the error information
 */
data class ApiResponse(
    val artistData: ArtistData?,
    val isSuccess: Boolean,
    val errorObject: ErrorObject?
)