package org.mathieu.data.remote.responses

import kotlinx.serialization.Serializable
import org.mathieu.domain.models.location.LocationPreview

/**
 * Represents detailed information about a locationPreview, typically received from an API response.
 *
 * @property id The unique identifier for the locationPreview.
 * @property name The name of the locationPreview.
 * @property type The type or category of the locationPreview.
 * @property dimension The specific dimension in which this locationPreview exists.
 */
@Serializable
internal data class LocationPreviewResponse(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String
) {
    /**
     * Converts the response object to a [LocationPreview] model object.
     *
     * @return The [LocationPreview] model object representing the locationPreview.
     */
    fun toModel(): LocationPreview {
        return LocationPreview(
            id = id,
            name = name,
            type = type,
            dimension = dimension
        )
    }
}