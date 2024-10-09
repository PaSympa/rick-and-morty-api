package org.mathieu.data.repositories

import org.mathieu.data.remote.LocationPreviewApi
import org.mathieu.domain.models.location.LocationPreview
import org.mathieu.domain.repositories.LocationPreviewRepository

internal class LocationPreviewRepositoryImpl (
    private val locationPreviewApi: LocationPreviewApi
) : LocationPreviewRepository{

    /**
     * Fetches the details of a specific location based on the provided ID.
     *
     * @param id The unique identifier of the location to be fetched.
     * @return Details of the specified location.
     */
    override suspend fun getLocationPreview(id: Int): LocationPreview {
        val response = locationPreviewApi.getLocationPreview(id)
        return response?.toModel() ?: throw Exception("LocationPreview not found")
    }

}