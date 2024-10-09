package org.mathieu.domain.repositories

import org.mathieu.domain.models.location.LocationPreview

interface LocationPreviewRepository {

    /**
     * Fetches the details of a specific location based on the provided ID.
     *
     * @param id The unique identifier of the location to be fetched.
     * @return Details of the specified location.
     */
    suspend fun getLocationPreview(id: Int): LocationPreview
}