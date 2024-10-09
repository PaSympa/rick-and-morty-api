package org.mathieu.data.remote.responses

import kotlinx.serialization.Serializable

/**
 * Represents detailed information about a locationPreview, typically received from an API response.
 *
 * @property id The unique identifier for the locationPreview.
 * @property name The name of the locationPreview.
 * @property type The type or category of the locationPreview.
 * @property dimension The specific dimension in which the locationPreview takes place.
 */
@Serializable
internal data class LocationPreviewResponse(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String
)