package org.mathieu.data.local.objects

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mathieu.data.remote.responses.LocationPreviewResponse
import org.mathieu.domain.models.location.LocationPreview

/**
 * Represents a locationPreviewObject entity stored in the SQLite database. This object provides fields
 * necessary to represent all the attributes of a locationPreviewObject from the data source.
 * The object is specifically tailored for SQLite storage using Realm.
 *
 * @property id Unique identifier of the character.
 * @property name Name of the character.
 * @property type The type of the location.
 * @property dimension The specific dimension or universe where this location exists.
 */
internal class LocationPreviewObject : RealmObject {
    @PrimaryKey
    var id: Int = -1
    var name: String = ""
    var type: String = ""
    var dimension: String = ""
}

/**
 * Converts a [LocationPreviewResponse] to a [LocationPreviewObject].
 */
internal fun LocationPreviewResponse.toRealmObject() = LocationPreviewObject().also { obj ->
    obj.id = id
    obj.name = name
    obj.type = type
    obj.dimension = dimension
}

/**
 * Converts a [LocationPreviewObject] to a [LocationPreview].
 */
internal fun LocationPreviewObject.toModel() = LocationPreview(
    id = id,
    name = name,
    type = type,
    dimension = dimension
)


